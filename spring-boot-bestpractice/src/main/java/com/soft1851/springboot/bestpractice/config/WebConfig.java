package com.soft1851.springboot.bestpractice.config;

import com.soft1851.springboot.bestpractice.filter.TrustedEndpointsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ke
 * @ClassName WebConfig
 * @Description TOOD
 * @Date 2020/5/17
 * @Version 1.0
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 内部端口
    //@Value("${server.trustedPort:null}")
    private String trustedPort;

    // 内部接口 URL 路径前缀
   // @Value("${server.trustedPathPrefix:null}")
    private String trustedPathPrefix;

//    @Bean
//    public FilterRegistrationBean<TrustedEndpointsFilter> trustedEndpointsFilter() {
//        return new FilterRegistrationBean<>(new TrustedEndpointsFilter(trustedPort, trustedPathPrefix));
//    }
}
