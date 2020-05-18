package com.soft1851.springboot.quartz.controller.dto;

import lombok.Data;

/**
 * @author ke
 * @ClassName ModifyCronDto
 * @Description TOOD
 * @Date 2020/5/19
 * @Version 1.0
 **/
@Data
public class ModifyCronDto {
    /**
     * 作业的id
     */
    private Integer id;

    /**
     * 作业的cron表达式
     */
    private String cron;
}