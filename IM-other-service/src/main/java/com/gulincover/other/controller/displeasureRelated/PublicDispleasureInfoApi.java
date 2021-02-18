package com.gulincover.other.controller.displeasureRelated;

import com.gulincover.api.HttpStateCode;
import com.gulincover.api.httpReq.displeasureReq.PostDispleasureInfoReq;
import com.gulincover.api.httpResp.displeasureResp.PostDispleasureResp;
import com.gulincover.other.service.DispleasureInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("PublicDispleasureInfoApi")
@RestController
public class PublicDispleasureInfoApi {
    @Autowired
    private DispleasureInfoRelatedService displeasureInfoRelatedService;

    @ApiOperation("/api/post/submit/displeasure/for/topic")
    @PostMapping("/api/post/submit/displeasure/for/topic")
    public PostDispleasureResp publicSubmitDispleasureForTopicApi(PostDispleasureInfoReq req) {
        PostDispleasureResp resp = new PostDispleasureResp();
        if (req.getTopicId() == null || req.getUserId() == null) {
            resp.setHttpStateCode(HttpStateCode.BAD_REQUEST);
            return resp;
        }
        Integer integer = displeasureInfoRelatedService.publicDispleasureForTopicByTopicId(req);
        if (integer > 0) {
            resp.setHttpStateCode(HttpStateCode.OK);
        }
        return resp;
    }

    @ApiOperation("/api/post/submit/displeasure/for/comment")
    @PostMapping("/api/post/submit/displeasure/for/comment")
    public PostDispleasureResp publicSubmitDispleasureForCommentApi(PostDispleasureInfoReq req) {
        PostDispleasureResp resp = new PostDispleasureResp();
        if (req.getCommentId() == null || req.getUserId() == null) {
            resp.setHttpStateCode(HttpStateCode.BAD_REQUEST);
            return resp;
        }
        Integer integer = displeasureInfoRelatedService.publicDispleasureForCommentByCommentId(req);
        if (integer > 0) {
            resp.setHttpStateCode(HttpStateCode.OK);
        }
        return resp;
    }

    @ApiOperation("/api/post/submit/displeasure/for/cancel")
    @PostMapping("/api/post/submit/displeasure/for/cancel")
    public PostDispleasureResp publicSubmitDispleasureForCancelApi(PostDispleasureInfoReq req) {
        PostDispleasureResp resp = new PostDispleasureResp();
        if (req.getUserId() != null) {
            if (req.getTopicId() != null && req.getCommentId() == null) {
                Integer integer = displeasureInfoRelatedService.publicDispleasureForCancelByTopicId(req);
                if (integer <= 0) {
                    resp.setHttpStateCode(HttpStateCode.BAD_REQUEST);
                } else {
                    resp.setHttpStateCode(HttpStateCode.OK);
                }
                return resp;
            } else if (req.getTopicId() == null && req.getCommentId() != null) {
                Integer integer = displeasureInfoRelatedService.publicDispleasureForCancelByCommentId(req);
                if (integer <= 0) {
                    resp.setHttpStateCode(HttpStateCode.BAD_REQUEST);
                } else {
                    resp.setHttpStateCode(HttpStateCode.OK);
                }
                return resp;
            }
        }

        resp.setHttpStateCode(HttpStateCode.BAD_REQUEST);
        return resp;
    }


}
