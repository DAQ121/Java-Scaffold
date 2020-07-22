package com.daq.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author 代澳旗
 * @description 添加了两个依赖之后，就要编写相应的配置类
 */

@Configuration
@EnableSwagger2// 开启Swagger2的自动配置
@SuppressWarnings("all")
public class SwaggerConfig {

    //第1步：通过apiInfo()属性配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("代澳旗", "https://daqwt.top/联系人访问链接", "daq2829025551@163.com");
        return new ApiInfo(
                "Swagger学习", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "https://daqwt.top/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }

    //第2步：Swagger实例Bean是Docket，所以通过配置Docket实例来配置Swaggger。
    @Bean //配置docket以配置Swagger具体参数
    public Docket docket(Environment environment) {
        Profiles of = Profiles.of("dev", "test");// 设置要显示swagger的环境
        boolean b = environment.acceptsProfiles(of);//判断当前是否处于该环境，通过 enable() 接收此参数判断是否要显示
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("mybatisplus") //分组的名称，如过有多个分组，就设置多个docket方法即可。这里的名字改一下就可以
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.daq.Springboot.demo.controller"))//根据这个包生成接口文档
                .build();
    }
}
