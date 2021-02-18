package com.gulincover.home.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulincover.api.entity.CommentInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentInfoMapper extends BaseMapper<CommentInfo> {
    CommentInfo selectCommentInfoByCommentId(Integer commentId);
    CommentInfo[] selectCommentInfosByTopicId(Integer topicId);
    CommentInfo[] selectCommentInfo1sByTopicId(Integer topicId);
    CommentInfo[] selectCommentInfo2sByCommentId(Integer commentId);
}
