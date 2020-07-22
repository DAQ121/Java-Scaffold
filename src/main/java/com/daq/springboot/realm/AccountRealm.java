package com.daq.springboot.realm;

import com.daq.springboot.demo.pojo.Account;
import com.daq.springboot.demo.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;

/**
 * @author daq
 * @description 这是shiro的认证和授权规则,必须继承 AuthorizingRealm类
 */
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private AccountService accountService;

    //先认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //客户端传过来的对象和密码，自动封装在token中，
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //根据用户名进行查询，并且判断
        Account account = accountService.findByUsername(token.getUsername());
        if (account != null){
            //用户名不为空，继续验证密码
            return new SimpleAuthenticationInfo(account,account.getPassword(),getName());
        }
        //用户名为空，直接跳出验证
        return null;
    }

    //再授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前用户邓登陆的信息
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();

        //设置角色
        Set<String> roles = new HashSet<>();
        roles.add(account.getRole());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        //设置权限
        info.addStringPermission(account.getPerms());
        return info;
    }

}
