package com.daq.springboot.demo.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author
 * @description
 */
@Component
@EnableScheduling
public class test{

    @Scheduled(cron = "0/2 * * * * ?")
    public void testCron(){
        System.out.println("你被执行了！！！！");
    }
}
