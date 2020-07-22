# Shiro

什么是 Shiro

官网：http://shiro.apache.org/

是一款主流的 Java 安全框架，不依赖任何容器，可以运行在 Java SE 和 Java EE 项目中，它的主要作用是对访问系统的用户进行身份认证、授权、会话管理、加密等操作。

Shiro 就是用来解决安全管理的系统化框架。



# Shiro 核心组件

用户、角色、权限

会给角色赋予权限，给用户赋予角色

1、UsernamePasswordToken，Shiro 用来封装用户登录信息，使用用户的登录信息来创建令牌 Token。

2、SecurityManager，Shiro 的核心部分，负责安全认证和授权。

3、Suject，Shiro 的一个抽象概念，包含了用户信息。

4、Realm，开发者自定义的模块，根据项目的需求，验证和授权的逻辑全部写在 Realm 中。

5、AuthenticationInfo，用户的角色信息集合，认证时使用。

6、AuthorzationInfo，角色的权限信息集合，授权时使用。

7、DefaultWebSecurityManager，安全管理器，开发者自定义的 Realm 需要注入到 DefaultWebSecurityManager 进行管理才能生效。

8、ShiroFilterFactoryBean，过滤器工厂，Shiro 的基本运行机制是开发者定制规则，Shiro 去执行，具体的执行操作就是由 ShiroFilterFactoryBean 创建的一个个 Filter 对象来完成。




# Spring Boot 整合 Shiro

1、创建 Spring Boot 应用，集成 Shiro 及相关组件，pom.xml

```xml
 <dependency>
    <groupId>org.apache.shiro</groupId>
    <artifactId>shiro-spring</artifactId>
    <version>1.5.3</version>
</dependency>
```

2、在 realm 中自定义 Shiro 过滤器

3、配置shiroConfig编写认证和授权规则

> 认证过滤器

anon：无需认证。

authc：必须认证。

authcBasic：需要通过 HTTPBasic 认证。

user：不一定通过认证，只要曾经被 Shiro 记录即可，比如：记住我。



> 授权过滤器

perms：必须拥有某个权限才能访问。

role：必须拥有某个角色才能访问。

port：请求的端口必须是指定值才可以。

rest：请求必须基于 RESTful，POST、PUT、GET、DELETE。

ssl：必须是安全的 URL 请求，协议 HTTPS。



## Shiro 整合 Thymeleaf

1、pom.xml 引入依赖

```xml
<dependency>
    <groupId>com.github.theborakompanioni</groupId>
    <artifactId>thymeleaf-extras-shiro</artifactId>
    <version>2.0.0</version>
</dependency>
```

2、配置类添加 ShiroDialect

```java
@Bean
public ShiroDialect shiroDialect(){
    return new ShiroDialect();
}
```

3. 在html中要加入
`<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:shiro="http://www.pollix.at/thymeleaf/shiro">
`