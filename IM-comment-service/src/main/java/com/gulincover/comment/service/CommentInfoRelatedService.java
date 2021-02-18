package com.gulincover.comment.service;

import com.gulincover.api.entity.CommentInfo;
import com.gulincover.comment.dao.CommentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentInfoRelatedService {
    @Autowired
    private CommentInfoMapper commentInfoMapper;

    public List<CommentInfo> inquireCommentInfo1sByTopicId(Long topicId) {
        return commentInfoMapper.selectCommentInfo1sByTopicId(topicId);
    }



    public CommentInfo inquireCommentInfoByCommentInfoByCommentId(Integer commentId) {
        return commentId <= 0 ? null : commentInfoMapper.selectCommentInfoByCommentId(commentId);
    }

    public CommentInfo[] inquireCommentInfosByCommentInfoByTopicId(Integer topicId) {
        return topicId <= 0 ? null : commentInfoMapper.selectCommentInfosByTopicId(topicId);
    }

    public CommentInfo[] inquireCommentInfo1sByCommentInfoByTopicId(Integer topicId) {
        return topicId <= 0 ? null : commentInfoMapper.selectCommentInfo1sByTopicId(topicId);
    }

    public CommentInfo[] inquireCommentInfo2sByCommentInfoByCommentId(Integer commentId) {
        return commentId <= 0 ? null : commentInfoMapper.selectCommentInfo2sByCommentId(commentId);
    }
}
