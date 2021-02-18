package com.gulincover.home.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulincover.api.entity.Related2Entry;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Related2EntryMapper extends BaseMapper<Related2Entry> {
    Integer[] selectEntryIdsByTopicId(Integer topicId);
    Integer[] selectEntryIdsByCommentId(Integer commentId);
}
