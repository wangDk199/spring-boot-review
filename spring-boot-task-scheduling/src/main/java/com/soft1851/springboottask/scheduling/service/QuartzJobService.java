package com.soft1851.springboottask.scheduling.service;

import com.soft1851.springboottask.scheduling.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ke
 * @ClassName QuartzJobService
 * @Description TOOD
 * @Date 2020/5/17
 * @Version 1.0
 **/
@Slf4j
@Service
public class QuartzJobService {

    //Quartz定时任务核心的功能实现类
    private Scheduler scheduler;

    public QuartzJobService(@Autowired SchedulerFactoryBean schedulerFactoryBean) {
        scheduler = schedulerFactoryBean.getScheduler();
    }

    /**
     * 创建和启动定时任务
     * {@link org.quartz.Scheduler#scheduleJob(JobDetail, Trigger)}
     *
     * @param task 定时任务
     */
    public void scheduleJob(Task task) throws SchedulerException, ClassNotFoundException {
        //定时任务的名字和组名
        JobKey jobKey = task.getJobKey();
        //定时任务的元数据
        JobDataMap jobDataMap = getJobDataMap(task.getJobDataMap());
        //定时任务的描述
        String desc = task.getDesc();
        //定时任务的逻辑实现类
        Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(task.getJobClass());
        //定时任务的cron表达式
        String cron = task.getCron();

        JobDetail jobDetail = getJobDetail(jobKey, desc, jobDataMap, jobClass);
        Trigger trigger = getTrigger(jobKey, desc, jobDataMap, cron);
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 暂停Job
     * {@link org.quartz.Scheduler#pauseJob(JobKey)}
     */
    public void pauseJob(JobKey jobKey) throws SchedulerException {
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复Job
     * {@link org.quartz.Scheduler#resumeJob(JobKey)}
     */
    public void resumeJob(JobKey jobKey) throws SchedulerException {
        scheduler.resumeJob(jobKey);
    }

    /**
     * 删除Job
     * {@link org.quartz.Scheduler#deleteJob(JobKey)}
     */
    public void deleteJob(JobKey jobKey) throws SchedulerException {
        scheduler.deleteJob(jobKey);
    }

    /**
     * 修改Job的cron表达式
     */
    public boolean modifyJobCron(Task task) {
        String cron = task.getCron();
        //如果cron表达式的格式不正确,则返回修改失败
        if (!CronExpression.isValidExpression(cron)) return false;
        JobKey jobKey = task.getJobKey();
        TriggerKey triggerKey = new TriggerKey(jobKey.getName(), jobKey.getGroup());
        try {
            CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            JobDataMap jobDataMap = getJobDataMap(task.getJobDataMap());
            //如果cron发生变化了,则按新cron触发 进行重新启动定时任务
            if (!cronTrigger.getCronExpression().equalsIgnoreCase(cron)) {
                CronTrigger trigger = TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey)
                        .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                        .usingJobData(jobDataMap)
                        .build();
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (SchedulerException e) {
            log.error("printStackTrace", e);
            return false;
        }
        return true;
    }

    /**
     * 获取定时任务的定义
     * JobDetail是任务的定义,Job是任务的执行逻辑
     *
     * @param jobKey     任务的名称和组名
     * @param desc       任务的描述
     * @param jobDataMap 任务的元数据
     * @param jobClass   {@link org.quartz.Job} 定时任务的 真正执行逻辑定义类
     */
    public JobDetail getJobDetail(JobKey jobKey, String desc, JobDataMap jobDataMap, Class<? extends Job> jobClass) {
        return JobBuilder.newJob(jobClass)
                .withIdentity(jobKey)
                .withDescription(desc)
                .setJobData(jobDataMap)
                .usingJobData(jobDataMap)
                .requestRecovery()
                .storeDurably()
                .build();
    }

    /**
     * 获取Trigger (Job的触发器,执行规则)
     *
     * @param jobKey         任务的名称和组名
     * @param description    任务的描述
     * @param jobDataMap     任务的元数据
     * @param cronExpression 任务的执行cron表达式
     */
    public Trigger getTrigger(JobKey jobKey, String description, JobDataMap jobDataMap, String cronExpression) {
        return TriggerBuilder.newTrigger()
                .withIdentity(jobKey.getName(), jobKey.getGroup())
                .withDescription(description)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .usingJobData(jobDataMap)
                .build();
    }

    public JobDataMap getJobDataMap(Map<?, ?> map) {
        return map == null ? new JobDataMap() : new JobDataMap(map);
    }

}