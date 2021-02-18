package com.gulincover.user.controller;

import com.gulincover.user.rpcService.RpcAuthCodeService;
import com.gulincover.user.service.UserInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("RpcPostController")
@RestController
public class RpcPostController {

    @Autowired
    private UserInfoRelatedService userInfoRelatedService;

    @Autowired
    private RpcAuthCodeService rpcAuthCodeService;

    @ApiOperation("/rpc/post/userInfo/for/prefect/userInfo")
    @PostMapping("/rpc/post/userInfo/for/prefect/userInfo")
    public Integer rpcPostPrefectUserInfo(Map<String, String> map) {
        Integer integer = userInfoRelatedService.updateUserInfo(map);
        return integer != null && integer == 1 ? 200 : -1;
    }
}













