package com.gulincover.topic.controller;

import com.alibaba.fastjson.JSON;
import com.gulincover.api.entity.EntryInfo;
import com.gulincover.api.entity.TopicInfo;
import com.gulincover.api.httpResp.topicPage.TopicPageTopicContentResp;
import com.gulincover.topic.rpcService.RpcEntryInfoService;
import com.gulincover.topic.service.TopicInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("InquireTopicInfoApi")
@RestController
public class InquireTopicInfoApi {
    @Autowired
    private TopicInfoRelatedService topicInfoRelatedService;

    /*
    api
     */
    @GetMapping("/rpc/get/topicInfo/exist/{id}")
    Integer isExist(@PathVariable("id") Long topicId) {
        return topicInfoRelatedService.isExist(topicId);
    }

    @GetMapping("/rpc/get/topicInfo/{id}")
    TopicInfo inquireTopicInfo(@PathVariable("id") Long topicId) {
        return topicInfoRelatedService.inquireTopicInfo(topicId);
    }


//    @ApiOperation("/api/topic/page/topicContent/{topicId}")
//    @GetMapping("/api/topic/page/topicContent/{topicId}")
//    public TopicPageTopicContentResp inquireTopicPageTopicContentViewApi(
//            @PathVariable("topicId") Integer topicId
//    ) {
//        TopicInfo topicInfo = topicInfoRelatedService.inquireTopicInfoByTopicInfoByTopicId(topicId);
//        if (topicInfo == null) return null;
//        TopicPageTopicContentResp topicPageTopicContentResp = new TopicPageTopicContentResp();
//        topicPageTopicContentResp.topicId = topicInfo.topicId;
//        topicPageTopicContentResp.content = topicInfo.content;
//        topicPageTopicContentResp.topicShareNumber = topicInfo.shareNumber == null ? 0 : topicInfo.shareNumber;
//        topicPageTopicContentResp.topicBrowseNumber = topicInfo.browseNumber == null ? 0 : topicInfo.browseNumber;
//        topicPageTopicContentResp.topicLikeNumber = topicInfo.likeNumber == null ? 0 : topicInfo.likeNumber;
//        topicPageTopicContentResp.topicName = topicInfo.topicName;
//        topicPageTopicContentResp.entryInfos = rpcGetEntryInfosByTopicId(topicId);
//        topicPageTopicContentResp.opinions = topicInfo.opinions;
//        return topicPageTopicContentResp;
//    }

    /*
    rpc
     */
    @Autowired
    private RpcEntryInfoService rpcEntryInfoService;

    public List<EntryInfo> rpcGetEntryInfosByTopicId(Integer topicId) {
        return rpcEntryInfoService.rpcGetEntryInfosByTopicId(topicId);
    }

    /*
    test
     */

//    @SentinelResource(value = "message",blockHandlerClass = RpcEntryInfosExceptionHandler.class,blockHandler = "blockHandler")
    @ApiOperation("/test/rpc/entry/entryInfos/by/{topicId}")
    @GetMapping("/test/rpc/entry/entryInfos/by/topic/{topicId}")
    public String testRpcEntryInfosByTopicId(
            @PathVariable("topicId") Integer topicId
    ) {
        List<EntryInfo> entryInfos = rpcGetEntryInfosByTopicId(topicId);
//        Arrays.stream(entryInfos).forEach(System.out::println);
        return JSON.toJSONString(entryInfos);
    }
}














