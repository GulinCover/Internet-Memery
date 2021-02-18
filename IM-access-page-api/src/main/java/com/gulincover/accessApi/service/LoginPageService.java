package com.gulincover.accessApi.service;

import com.gulincover.accessApi.rpcService.RpcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginPageService {

    @Autowired
    private RpcUserService rpcUserService;

    public String emailLogin(String email, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("email",email);
        map.put("pwd",pwd);
        return rpcUserService.postEmailLogin(map);
    }

    public String phoneLogin(String phone, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("phone",phone);
        map.put("pwd",pwd);
        return rpcUserService.postPhoneLogin(map);
    }
}
