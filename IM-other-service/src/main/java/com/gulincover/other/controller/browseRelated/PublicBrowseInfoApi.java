package com.gulincover.other.controller.browseRelated;

import com.gulincover.api.HttpStateCode;
import com.gulincover.other.service.BrowseInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("PublicBrowseInfoApi")
@RestController
public class PublicBrowseInfoApi {
    @Autowired
    private BrowseInfoRelatedService browseInfoRelatedService;

    @ApiOperation("/api/post/submit/topic/browseInfo")
    @PostMapping("/api/post/submit/topic/browseInfo")
    public String publicBrowseInfoForTopicApi(Long userId, Long topicId) {
        return browseInfoRelatedService.publicTopicHistoryByBrowseInfo(userId, topicId) > 0 ? HttpStateCode.OK.toString() : HttpStateCode.BAD_REQUEST.toString();
    }

    @ApiOperation("/api/post/submit/user/browseInfo")
    @PostMapping("/api/post/submit/user/browseInfo")
    public String publicBrowseInfoForUserApi(Long userId, Long user) {
        return browseInfoRelatedService.publicUserHistoryByBrowseInfo(userId, user) > 0 ? HttpStateCode.OK.toString() : HttpStateCode.BAD_REQUEST.toString();
    }
}
