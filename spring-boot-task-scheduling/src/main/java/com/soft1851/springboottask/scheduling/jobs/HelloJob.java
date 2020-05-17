package com.soft1851.springboottask.scheduling.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

import java.util.Date;

/**
 * @author ke
 * @ClassName HelloJob
 * @Description TOOD
 * @Date 2020/5/17
 * @Version 1.0
 **/
@DisallowConcurrentExecution    //相同定义的jobDetail不能并发执行
@PersistJobDataAfterExecution   //jobDataMap数据保存
@Slf4j
public class HelloJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("springboot整合定时任务Quartz:" + new Date());
    }
}
