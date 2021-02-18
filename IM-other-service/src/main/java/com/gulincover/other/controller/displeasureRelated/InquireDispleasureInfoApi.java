package com.gulincover.other.controller.displeasureRelated;

import com.gulincover.api.HttpStateCode;
import com.gulincover.api.httpResp.displeasureResp.GetDispleasureNumberResp;
import com.gulincover.other.service.DispleasureInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api("InquireDispleasureInfoApi")
@RestController
public class InquireDispleasureInfoApi {
    @Autowired
    private DispleasureInfoRelatedService displeasureInfoRelatedService;

    @ApiOperation("/api/get/inquire/displeasureNumber/for/topic/{topicId}")
    @GetMapping("/api/get/inquire/displeasureNumber/for/topic/{topicId}")
    public GetDispleasureNumberResp inquireGetDispleasureNumberForTopicByTopicIdApi(@PathVariable("topicId")Long topicId) {
        GetDispleasureNumberResp resp = new GetDispleasureNumberResp();
        resp.setNumber(displeasureInfoRelatedService.inquireDispleasureNumberForTopicByTopicId(topicId));
        resp.setHttpStateCode(HttpStateCode.OK);
        return resp;
    }

    @ApiOperation("/api/get/inquire/displeasureNumber/for/comment/{commentId}")
    @GetMapping("/api/get/inquire/displeasureNumber/for/comment/{commentId}")
    public GetDispleasureNumberResp inquireGetDispleasureNumberForCommentByCommentIdApi(@PathVariable("commentId")Long commentId) {
        GetDispleasureNumberResp resp = new GetDispleasureNumberResp();
        resp.setNumber(displeasureInfoRelatedService.inquireDispleasureNumberForCommentByCommentId(commentId));
        resp.setHttpStateCode(HttpStateCode.OK);
        return resp;
    }
}
