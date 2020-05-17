package com.soft1851.springboottask.scheduling.model;

import lombok.Builder;
import lombok.Data;
import org.quartz.JobKey;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;


/**
 * @author ke
 * @ClassName Task
 * @Description TOOD
 * @Date 2020/5/17
 * @Version 1.0
 **/
@Data
@Builder
public class Task {
    /**
     * 任务名称
     */
    @NotEmpty(message = "任务名称不能为空")
    private String name;

    /**
     * 任务分组
     */
    @NotEmpty(message = "任务分组不能为空")
    private String group;

    /**
     * corn表达式
     */
    @NotEmpty(message = "定时任务的表达式不能为空")
    private String cron;

    /**
     * 任务描述
     */
    private String desc;

    /**
     * 执行任务的逻辑类
     */
    @NotNull(message = "执行任务的逻辑类名不能为空")
    private String jobClass;

    /**
     * 元数据
     */
    private Map<?, ?> jobDataMap;

    public JobKey getJobKey() {
        return JobKey.jobKey(this.name, this.group);
    }
}
