package com.gulincover.home.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulincover.api.entity.EntryInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EntryInfoMapper extends BaseMapper<EntryInfo> {
    EntryInfo[] selectEntryInfosByEntryIds(Integer[] entryIds);
    EntryInfo selectEntryInfoByEntryId(Integer entryId);
}
