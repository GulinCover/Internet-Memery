package com.gulincover.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.gulincover.api.HttpStateCode;
import com.gulincover.api.entity.UserInfo;
import com.gulincover.user.service.UserInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@Api("InquireUserInfoApi")
@RestController
public class InquireUserInfoApi {
    @Autowired
    private UserInfoRelatedService userInfoRelatedService;

    /*
    api
     */

    @ApiOperation("/rpc/get/userInfo/by/{userId}")
    @GetMapping("/rpc/get/userInfo/by/{userId}")
    public UserInfo apiGetUserInfoByUserId(@PathVariable("userId") Long id) {
        return userInfoRelatedService.inquireUserInfoByUserInfoByUserId(id);
    }

    /*
    rpc
     */
    @ApiOperation("/rpc/user/info/by/userId")
    @PostMapping("/rpc/user/userinfo/by/userId")
    public UserInfo rpcGetUserInfoByUserIdApi(Long id){
        return userInfoRelatedService.inquireUserInfoByUserInfoByUserId(id);
    }

    @ApiOperation("/rpc/user/userinfos/by/userIds")
    @PostMapping("/rpc/user/userinfos/by/userIds")
    public UserInfo[] rpcGetUserInfosByUserIdsApi(Long[] userIds){
        int length = userIds.length;
        UserInfo[] userInfos = new UserInfo[length];
        for (int i = 0;i<length;++i) {
            userInfos[i] = userInfoRelatedService.inquireUserInfoByUserInfoByUserId(userIds[i]);
        }
        return userInfos;
    }

    /*
    test
     */
    @ApiOperation("/api/get/test/userInfo/{id}")
    @GetMapping("/api/get/test/userInfo/{id}")
    public String inquireGetTest(@PathVariable("id")int i) {
        return 1 == i ? HttpStateCode.OK.toString() : HttpStateCode.BAD_REQUEST.toString();
    }

    @ApiOperation("/api/post/test/userInfo")
    @PostMapping("/api/post/test/userInfo")
    public String inquirePostTest(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
        System.out.println(request.getHeader("GulinCoverAuthenticationCode"));
        return HttpStateCode.OK.toString();
    }
}











