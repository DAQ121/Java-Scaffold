package com.daq.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync //开启异步任务的注解，在业务层的方法上加上@Async注解就实现了异步任务
@EnableScheduling //开启定时任务的注解，在业务层的方法上加上@Scheduled注解，在注解中写cron表达式即可
@SpringBootApplication
@MapperScan("com.daq.Springboot.demo.mapper")
public class SpringbootApplication {
	public static void main(String[] args) throws Exception { SpringApplication.run(SpringbootApplication.class, args); }

}
