# :floppy_disk:序言
- 项目的基础框架：后端是`SpringBoot`，前端是`layui`，恳求各位大佬一个`star`和`fork`吧！也希望收到指点，与帮助:heart_eyes:！！
- 目前集成了如下组件（完善中~）：
1. `MybatisPlus`：根据表，自动生成代码，简单的sql语句不用写，不过复杂的多表查询还是要自己动手的。
1. `Druid`数据源：安全可靠，还有可视化界面。
2. `Redis`缓存：需要在本地开启`redis`。
3. `Shiro`安全框架：更轻量，更简单。
4. `Swagger`接口文档：自动生成接口文档，有可视化界面。
5. `Async`异步任务
6. `mail`邮件任务
7. `Scheduling`定时任务


# :bookmark_tabs:项目结构

```
com
    └─daq
        └─springboot
            │  SpringbootApplication.java  #启动类
            │
            ├─config
            │      AutoCode.java        #MybatisPlus自动生成代码的类
            │      DruidConfig.java     #Druid数据源配置文件
            │      RedisConfig.java     #redis序列化配置模板
            │      ShiroConfig.java     #shiro配置文件
            │      SwaggerConfig.java   #Swagger配置文件
            │
            ├─notes     #笔记,记录一些配置的过程
            │      druid.md
            │      jedis.md
            │      JSR303.md
            │      mail.md
            │      mybatis-plus.md
            │      Shiro.md
            │      Swagger.md
            ├─realm  #shiro的认证和授权规则
            │      AccountRealm.java          
            │
            └─utils  #工具类
                    SendMailUtil.java #发送邮件的工具类
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200722161439539.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDg2MTM5OQ==,size_16,color_FFFFFF,t_70)


# :notebook_with_decorative_cover:使用方法
- 将项目导入`IDEA`，用`sql`文件建好数据库。 	:gift_heart:
-  :christmas_tree:**数据源修改：** 
1. 在`applicatiion-dev.yml`中找到数据源配置，修改你的数据库名，以及用户名和密码。
2. 在` DruidConfig`中的用户名和密码是后台管理界面的登录账号和密码。
-  :fax:**自动生成代码修改：**
3. 在`AutoCode`中修改生成代码的作者名字。
4. 更改数据源。
5. 配置代码生成路径。以及父包的名称。
6. 在策略配置中，设置要映射的表名，可以一次填写多个，根据表名生成相应的代码。
- :scroll:**redis模板**
7. 这个可以直接使用
- :bookmark_tabs:**Shiro登录认证配置**
8. 在`ShiroConfig`中设置与数据库对应的权限。
9. 设置登录页面 
- :horse_racing:**Swagger配置**
10. 通过`apiInfo()`属性配置文档信息
11. 配置`docket`以配置`Swagger`具体参数

- :birthday:**异步任务**
12. 在`SpringbootApplication`类上加`@EnableAsync`注解，开启异步任务
13. 然后有异步任务需要的业务层方法上加上 `@Async`注解就实现了异步任务

- :shaved_ice:**定时任务**
14.  在`SpringbootApplication`类上加`@EnableScheduling`注解，开启定时任务。
15. 在业务层的方法上加上`@Scheduled`注解，在注解中写`cron`表达式即可。`cron`表达式怎么写？，百度即可，也有`cron`表达式在线生成工具。

- :mailbox_with_no_mail:**邮件任务**
16. 将QQ邮箱的 `POP3/SMTP` 服务开启,获取到邮箱秘钥
18. 在`yml`配置文件中加入 `用户名`，`邮箱秘钥`，服务器地址（有默认值） 以及加密的配置。
19. 将方法封装在工具类中，使用的时候调用`MailUtil`的方法，写入消息和发送方。


# :telephone:联系我
- 如果有想要加入的童鞋，我们可以一起把这个脚手架做得更好，方便以后开发，提出你想要集成或者你觉得有意思的组件吧。欢迎Q我`2829025551`。

