package com.soft1851.springboottask.scheduling.controller;

import com.soft1851.springboottask.scheduling.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ke
 * @ClassName AsyncTaskController
 * @Description TOOD
 * @Date 2020/5/17
 * @Version 1.0
 **/
@RestController
@Slf4j
public class AsyncTaskController {

    @Resource
    private AsyncTaskService asyncTaskService;

    @RequestMapping("/asyncTask")
    public String asyncTask() {
        asyncTaskService.asyncTask();
        return "测试异步任务...";
    }
}
