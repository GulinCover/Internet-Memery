package com.gulincover.user.config.shiro;

import com.gulincover.user.service.UserInfoRelatedService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoRelatedService userInfoRelatedService;

    public void setName(String name) {
        super.setName("ShiroRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String access = (String) principals.getPrimaryPrincipal();

        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String access = upToken.getUsername();
        String password = String.valueOf(upToken.getPassword());

        Long aLong = 0L;
        if (Pattern.matches(".*@.*", access)) {
            System.out.println(1111);
            aLong = userInfoRelatedService.loginEmail(access, password);
        } else {
            aLong = userInfoRelatedService.loginPhone(access, password);
        }

        if (aLong == null || aLong != 1) throw new RuntimeException("登陆账号或密码错误");

        return new SimpleAuthenticationInfo(access, password, getName());
    }
}
