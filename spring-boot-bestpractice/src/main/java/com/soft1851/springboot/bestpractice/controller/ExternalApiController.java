package com.soft1851.springboot.bestpractice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ke
 * @ClassName ExternalApiController
 * @Description TOOD
 * @Date 2020/5/17
 * @Version 1.0
 **/
@Controller
public class ExternalApiController {
    @GetMapping("/external/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello stranger");
    }
}

// 内部接口的 URL 路径以 /internal/ 作为前缀
//@Controller
//public class InternalApiController {
//    @GetMapping("/internal/hello")
//    public ResponseEntity<String> hello() {
//        return ResponseEntity.ok("Hello friend");
//    }
//}