package com.gulincover.accessApi.service;

import com.gulincover.accessApi.rpcService.RpcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegisterPagerService {
    @Autowired
    private RpcUserService rpcUserService;
    public Integer register(Map<String, String> map) {
        return rpcUserService.register(map);
    }
}
