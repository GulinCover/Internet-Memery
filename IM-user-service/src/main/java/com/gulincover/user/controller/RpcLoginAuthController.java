package com.gulincover.user.controller;

import com.gulincover.user.rpcService.RpcAuthCodeService;
import com.gulincover.user.service.UserInfoRelatedService;
import com.gulincover.utils.tools.JjwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api("RpcLoginAuthController")
@RestController
public class RpcLoginAuthController {

    @Autowired
    private UserInfoRelatedService userInfoRelatedService;

    @Autowired
    private RpcAuthCodeService rpcAuthCodeService;

    @ApiOperation("/rpc/post/userInfo/for/email/login")
    @PostMapping(value = "/rpc/post/userInfo/for/email/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String postEmailLogin(String email, String pwd) {
        Long userId = userInfoRelatedService.findUserIdByEmail(email);
        if (userId == null || userId < 1L || email.equals("") || pwd.equals("")) {
            return "";
        }

        UsernamePasswordToken upToken = new UsernamePasswordToken(email, pwd);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(upToken);
        } catch (Exception e) {
            return "";
        }

        Date date = new Date();
        String authCode = rpcAuthCodeService.getAuthCode(date);
        if (authCode.equals("")) return "";

        JjwtUtils jjwtUtils = new JjwtUtils();
        Map<String, Object> map = new HashMap<>();
        map.put("dateKey",authCode);

        return jjwtUtils.createJwt(userId, email, map, date);
    }

    @ApiOperation("/rpc/post/userInfo/for/phone/login")
    @PostMapping(value = "/rpc/post/userInfo/for/phone/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String postPhoneLogin(@RequestBody Map<String, String> map) {
        System.out.println(map);
        Long userId = userInfoRelatedService.findUserIdByPhone(map.get("phone"));
        if (userId == null || userId < 1L || map.get("phone").equals("") || map.get("pwd").equals("")) {
            return "";
        }

        UsernamePasswordToken upToken = new UsernamePasswordToken(map.get("phone"), map.get("pwd"));
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(upToken);
        } catch (Exception e) {
            return "";
        }

        Date date = new Date();
        String authCode = rpcAuthCodeService.getAuthCode(date);
        if (authCode.equals("")) return "";

        Map<String, Object> attachMap = new HashMap<>();
        attachMap.put("dateKey",authCode);
        JjwtUtils jjwtUtils = new JjwtUtils();
        return jjwtUtils.createJwt(userId, map.get("phone"), attachMap, date);
    }

    @ApiOperation("/rpc/get/userInfo/for/userId/by/{userId}")
    @GetMapping("/rpc/get/userInfo/for/userId/by/{userId}")
    public Long getUserId(@PathVariable("userId")Long userId) {
        return userInfoRelatedService.findUserIdById(userId);
    }
}
