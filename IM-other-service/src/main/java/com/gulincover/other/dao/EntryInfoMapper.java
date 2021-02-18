package com.gulincover.other.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulincover.api.entity.EntryInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EntryInfoMapper extends BaseMapper<EntryInfo> {
    EntryInfo[] selectEntryInfosByEntryIds(Integer[] entryIds);
    EntryInfo selectEntryInfoByEntryId(Integer entryId);
    List<EntryInfo> selectEntryInfosByTopicId(Long topicId);
}
