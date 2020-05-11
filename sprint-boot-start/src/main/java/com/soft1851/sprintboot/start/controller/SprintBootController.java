package com.soft1851.sprintboot.start.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ke
 * @ClassName SprintBootController
 * @Description TOOD
 * @Date 2020/5/11
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api")
class SpringBootController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
}

