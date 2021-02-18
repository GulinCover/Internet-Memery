package com.gulincover.home.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulincover.api.entity.TopicInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicInfoMapper extends BaseMapper<TopicInfo> {
    TopicInfo selectTopicInfoByTopicId(Integer topicId);
}
