package com.gulincover.accessApi.controller;

import com.gulincover.api.httpResp.topicPage.Comment1sResp;
import com.gulincover.api.httpResp.topicPage.Comment2sResp;
import com.gulincover.api.httpResp.topicPage.TopicResp;
import com.gulincover.accessApi.service.TopicPageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api("BTopicPageController")
@RestController
public class BTopicPageController {

    @Autowired
    private TopicPageService topicService;

    /*
    api
     */
    @ApiOperation("/api/topic/page/{id}")
    @GetMapping("/api/topic/page/{id}")
    public TopicResp apiGetTopicPageForTopic(@PathVariable("id")Long id) {
        return topicService.topicPage(id);
    }

    @ApiOperation("/api/topic/page/comment1/{topicId}")
    @GetMapping("/api/topic/page/comment1/{topicId}")
    public Comment1sResp apiGetTopicPageForComment1(@PathVariable("topicId")Long id) {
        return topicService.topicPageForComment1(id);
    }

    @ApiOperation("/api/topic/page/comment2/{commentId}")
    @GetMapping("/api/topic/page/comment2/{commentId}")
    public Comment2sResp apiGetTopicPageForComment2(@PathVariable("commentId")Long id) {
        return topicService.topicPageForComment2(id);
    }
}


















