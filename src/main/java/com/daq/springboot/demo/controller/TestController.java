package com.daq.springboot.demo.controller;

import com.daq.springboot.demo.pojo.Login;
import com.daq.springboot.demo.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Controller
@SuppressWarnings("all")
public class TestController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    //测试简单的数据传输
    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg","daiaoqi");
        return "test";
    }

    //简单测试redis
    @RequestMapping("/testRedis")
    public String redis(){
        redisTemplate.opsForValue().set("k2","wt");
        String str = redisTemplate.opsForValue().get("k2");
        return str;
    }

    //测试thymeleaf遍历集合
    @RequestMapping("/t2")
    public String test2(Map<String,Object> map){
        //存入数据
        map.put("msg","<h1>Hello</h1>");
        map.put("users", Arrays.asList("daiaoqi","wutong"));
        return "test2";
    }

    //测试接口
    @RequestMapping("/getUser")
    public User getUser(){
        return new User();
    }

    //测试swagger的实体类接口
    @ApiOperation("测试实体类接口")
    @PostMapping("/daq")
    @ResponseBody
    public String kuang(@ApiParam("这个名字会被返回")String username){
        return username;
    }

    //测试JSR303数据校验
    @PostMapping("/tsetValidator")
    public Object validatorObject(@Validated Login login, BindingResult br){
        Map<String,Object> errorMap = new HashMap<String,Object>();
        if(br.hasErrors()){
            //对错误集合进行遍历,有的话,直接放入map集合中
            br.getFieldErrors().forEach(p->{
                errorMap.put(p.getField(), p.getDefaultMessage());
            });
        }
        //返回错误信息
        return errorMap;
    }

}