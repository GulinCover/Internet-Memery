package com.gulincover.other.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gulincover.api.entity.DispleasureInfo;
import com.gulincover.api.httpReq.displeasureReq.PostDispleasureInfoReq;
import com.gulincover.api.httpResp.displeasureResp.PostDispleasureResp;
import com.gulincover.other.dao.DispleasureInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispleasureInfoRelatedService {
    @Autowired
    private DispleasureInfoMapper displeasureInfoMapper;

    public Integer inquireDispleasureNumberForTopicByTopicId(Long topicId) {
        return displeasureInfoMapper.inquireDispleasureNumberForTopicByTopicId(topicId);
    }

    public Integer inquireDispleasureNumberForCommentByCommentId(Long commentId) {
        return displeasureInfoMapper.inquireDispleasureNumberForCommentByCommentId(commentId);
    }

    public Integer publicDispleasureForTopicByTopicId(PostDispleasureInfoReq req) {
        Integer integer = displeasureInfoMapper.inquireDispleasureInfoIsExistByTopicId(req.getUserId(), req.getTopicId());
        if (integer == null || integer <= 0) return 0;
        DispleasureInfo displeasureInfo = new DispleasureInfo();
        displeasureInfo.setTopicId(req.getTopicId());
        displeasureInfo.setUserId(req.getUserId());
        return displeasureInfoMapper.insert(displeasureInfo);
    }

    public Integer publicDispleasureForCommentByCommentId(PostDispleasureInfoReq req) {
        Integer integer = displeasureInfoMapper.inquireDispleasureInfoIsExistByCommentId(req.getUserId(), req.getCommentId());
        if (integer == null || integer <= 0) return 0;
        DispleasureInfo displeasureInfo = new DispleasureInfo();
        displeasureInfo.setCommentId(req.getCommentId());
        displeasureInfo.setUserId(req.getUserId());
        return displeasureInfoMapper.insert(displeasureInfo);
    }

    public Integer publicDispleasureForCancelByTopicId(PostDispleasureInfoReq req) {
        Integer integer = displeasureInfoMapper.inquireDispleasureInfoIsExistByCommentId(req.getUserId(), req.getTopicId());
        if (integer == null || integer <= 0) return 0;
        QueryWrapper<DispleasureInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",req.getUserId()).eq("topic_id",req.getTopicId());
        return displeasureInfoMapper.delete(wrapper);
    }

    public Integer publicDispleasureForCancelByCommentId(PostDispleasureInfoReq req) {
        Integer integer = displeasureInfoMapper.inquireDispleasureInfoIsExistByCommentId(req.getUserId(), req.getCommentId());
        if (integer == null || integer <= 0) return 0;
        QueryWrapper<DispleasureInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",req.getUserId()).eq("comment_id",req.getCommentId());
        return displeasureInfoMapper.delete(wrapper);
    }
}
