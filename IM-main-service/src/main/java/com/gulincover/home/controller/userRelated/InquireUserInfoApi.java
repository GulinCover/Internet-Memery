package com.gulincover.home.controller.userRelated;

import com.gulincover.api.entity.UserInfo;
import com.gulincover.home.service.userRelated.UserInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("InquireUserInfoApi")
@RestController
public class InquireUserInfoApi {
    @Autowired
    private UserInfoRelatedService userInfoRelatedService;

    @ApiOperation("/rpc/user/info/by/userId")
    @PostMapping("/rpc/user/userinfo/by/userId")
    public UserInfo rpcGetUserInfoByUserId(Integer userId){
        return userInfoRelatedService.inquireUserInfoByUserInfoByUserId(userId);
    }

    @ApiOperation("/rpc/user/userinfos/by/userIds")
    @PostMapping("/rpc/user/userinfos/by/userIds")
    public UserInfo[] rpcGetUserInfosByUserIds(Integer[] userIds){
        int length = userIds.length;
        UserInfo[] userInfos = new UserInfo[length];
        for (int i = 0;i<length;++i) {
            userInfos[i] = userInfoRelatedService.inquireUserInfoByUserInfoByUserId(userIds[i]);
        }
        return userInfos;
    }
}
