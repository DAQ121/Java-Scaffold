package com.daq.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 代澳旗
 * 前后端分离的项目中，接口和页面往往部署中不同的服务中，这个时候就是出现跨域的问题
 * 通过实现WebMvcConfigurer接口然后重写addCorsMappings方法解决跨域问题。
 */

@Configuration
@SuppressWarnings("all")
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String mapping = "/**"; // 所有请求，也可配置成特定请求，如/api/**
        String origins = "*"; // 所有来源，也可以配置成特定的来源才允许跨域，如http://www.xxxx.com
        String methods = "*"; // 所有方法，GET、POST、PUT等
        registry.addMapping(mapping).allowedOrigins(origins).allowedMethods(methods).allowCredentials(true);
    }
}