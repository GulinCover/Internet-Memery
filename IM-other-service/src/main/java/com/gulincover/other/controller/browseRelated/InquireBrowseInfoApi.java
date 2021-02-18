package com.gulincover.other.controller.browseRelated;

import com.gulincover.api.HttpStateCode;
import com.gulincover.api.httpReq.browseReq.PostBrowseInfoReq;
import com.gulincover.api.httpResp.browseResp.PostBrowseInfoResp;
import com.gulincover.other.service.BrowseInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("InquireBrowseInfoApi")
@RestController
public class InquireBrowseInfoApi {
    @Autowired
    private BrowseInfoRelatedService browseInfoRelatedService;

    @ApiOperation("/api/post/inquire/browse/topicInfo")
    @PostMapping("/api/post/inquire/browse/topicInfo")
    public PostBrowseInfoResp inquirePostTopicHistoryApi(PostBrowseInfoReq req) {
        PostBrowseInfoResp postBrowseInfoResp = new PostBrowseInfoResp();
        if (req.getStart() == null || req.getEnd() == null) {
            postBrowseInfoResp.setHttpStateCode(HttpStateCode.NOT_FOUND);
            postBrowseInfoResp.setResult(null);
        }
        postBrowseInfoResp.setHttpStateCode(HttpStateCode.OK);
        postBrowseInfoResp.setResult(browseInfoRelatedService.inquireTopicHistory(req));
        return postBrowseInfoResp;
    }
}








