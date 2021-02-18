package com.gulincover.home.service.commentRelated;

import com.gulincover.api.entity.CommentInfo;
import com.gulincover.home.dao.CommentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentInfoRelatedService {
    @Autowired
    private CommentInfoMapper commentInfoMapper;

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
