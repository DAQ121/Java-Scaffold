## Druid数据源
1. 导入依赖druid
2. 在application.yml中配置
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource # 自定义数据源
    
3. 导入Log4j 的依赖
4. 测试后类中测试

## 配置Druid数据源监控
- 在配置文件中写好了，直接拿来用，访问页面`http://localhost:8080/druid/login.html`

## 配置 Druid web 监控 filter 过滤器
- 也在配置文件中写好
