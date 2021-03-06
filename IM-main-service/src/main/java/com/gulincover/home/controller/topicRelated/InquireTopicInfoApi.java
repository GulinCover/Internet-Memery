//package com.gulincover.home.controller.topicRelated;
//
//import com.gulincover.api.entity.EntryInfo;
//import com.gulincover.api.entity.TopicInfo;
//import com.gulincover.api.httpResp.topicPage.TopicPageTopicContentResp;
//import com.gulincover.home.rpcService.RpcEntryInfoService;
//import com.gulincover.home.service.topicRelated.TopicInfoRelatedService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@Api("InquireTopicPageViewApi")
//@RestController
//public class InquireTopicInfoApi {
//    @Autowired
//    private TopicInfoRelatedService topicInfoRelatedService;
//
//    /*
//    api
//     */
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
//
//    /*
//    rpc
//     */
//    @Autowired
//    private RpcEntryInfoService rpcEntryInfoService;
//
//    public EntryInfo[] rpcGetEntryInfosByTopicId(Integer topicId) {
//        return rpcEntryInfoService.rpcGetEntryInfosByTopicId(topicId);
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
