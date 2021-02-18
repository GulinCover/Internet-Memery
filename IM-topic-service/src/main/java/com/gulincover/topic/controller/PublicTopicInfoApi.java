package com.gulincover.topic.controller;

import com.gulincover.api.HttpStateCode;
import com.gulincover.api.entity.UserInfo;
import com.gulincover.api.httpReq.PublicTopicInfoAbs;
import com.gulincover.topic.rpcService.RpcUserInfoService;
import com.gulincover.topic.service.TopicInfoRelatedService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("PublicTopicInfoApi")
@RestController
public class PublicTopicInfoApi {
    @Autowired
    private TopicInfoRelatedService topicInfoRelatedService;

    /*
    api
     */
//    @PostMapping("/api/post/public/topicInfo")
//    public String publicTopicInfoApi(PublicTopicInfoAbs publicTopicInfoAbs) {
//        Long userId = publicTopicInfoAbs.getUserId();
////        UserInfo userInfo = rpcGetUserInfoByUserId(userId);
////        if (userInfo == null) return HttpStateCode.CUSTOMIZE_USERINFO_ERROR.toString();
//
//        Integer integer = topicInfoRelatedService.insetTopicInfo(userId, publicTopicInfoAbs.getTopicName(), publicTopicInfoAbs.getTopicContent());
//
//        return HttpStateCode.OK.toString();
//    }

    /*
    rpc
     */

    @Autowired
    private RpcUserInfoService rpcUserInfoService;

    public UserInfo rpcGetUserInfoByUserId(Integer userId) {
        return rpcUserInfoService.rpcGetUserInfoByUserId(userId);
    }
}












