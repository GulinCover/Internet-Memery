package com.gulincover.other.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulincover.api.entity.DispleasureInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DispleasureInfoMapper extends BaseMapper<DispleasureInfo> {
    Integer inquireDispleasureNumberForTopicByTopicId(Long topicId);

    Integer inquireDispleasureNumberForCommentByCommentId(Long commentId);

    Integer inquireDispleasureInfoIsExistByTopicId(Long userId, Long topicId);

    Integer inquireDispleasureInfoIsExistByCommentId(Long userId, Long commentId);
}
