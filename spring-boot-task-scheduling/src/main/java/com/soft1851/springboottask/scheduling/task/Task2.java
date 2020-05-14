package com.soft1851.springboottask.scheduling.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.DataFormatException;

/**
 * @author ke
 * @ClassName Task2
 * @Description TOOD
 * @Date 2020/5/14
 * @Version 1.0
 **/
@Component
public class Task2 {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime1() {
        System.out.println(Thread.currentThread() + "现在时间：" + dtf.format(LocalDateTime.now()));

    }

    @Scheduled(fixedDelay = 2000)
    public void reportCurrentTime2() {
        System.out.println(Thread.currentThread() +"现在时间：" + dtf.format(LocalDateTime.now()));

    }

    @Scheduled(initialDelay = 3000, fixedDelay = 2000)
    public void reportCurrentTime3() {
        System.out.println(Thread.currentThread() +"现在时间：" + dtf.format(LocalDateTime.now()));

    }
}
