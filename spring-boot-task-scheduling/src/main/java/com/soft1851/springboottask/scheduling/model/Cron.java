package com.soft1851.springboottask.scheduling.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ke
 * @ClassName Cron
 * @Description TOOD
 * @Date 2020/5/15
 * @Version 1.0
 **/
@Data
@Entity
public class Cron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cronId;

    @Column(name = "cron_name", nullable = false, length = 30)
    private String cronName;

    @Column(name = "cron", nullable = false, length = 50)
    private String cron;
}
