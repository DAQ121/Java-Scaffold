package com.daq.springboot.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.daq.springboot.realm.AccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author 代澳旗
 * 这是shiro的配置文件，
 */
@Configuration
public class ShiroConfig {

    //注入realm
    @Bean
    public AccountRealm accountRealm(){
        return new AccountRealm();
    }

    //注入安全管理器
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("accountRealm") AccountRealm accountRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(accountRealm);
        return manager;
    }

    //注入工厂
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        //权限设置
        Map<String,String> map = new Hashtable<>();
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/administrator","roles[administrator]");
        factoryBean.setFilterChainDefinitionMap(map);
        //设置登陆页面
        factoryBean.setLoginUrl("/login");
        //设置未授权页面
        factoryBean.setUnauthorizedUrl("/unauth");
        return factoryBean;
    }

    //shiro整合thymeleaf,要想在html中使用shiro，就必须先引进方言。
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
