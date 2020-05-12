package com.soft1851.springboot.configuration;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootConfigApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootConfigApplication.class, args);
        new SpringApplicationBuilder(SpringBootApplication.class).bannerMode(Banner.Mode.CONSOLE).run(args);
    }

}
