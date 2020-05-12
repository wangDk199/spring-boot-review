package com.soft1851.springboot.configuration.controller;

import com.soft1851.springboot.configuration.model.Music;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ke
 * @ClassName MusicController
 * @Description TOOD
 * @Date 2020/5/12
 * @Version 1.0
 **/
@RestController
@Slf4j
public class MusicController {
    @Resource
    private Music music;

    @Value("${music.name}")
    private String name;

    @GetMapping("/music")
    public Music music() {
        log.info(String.valueOf(music));
        log.info(name);
        return music;
    }

}
