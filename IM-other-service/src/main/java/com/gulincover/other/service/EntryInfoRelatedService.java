package com.gulincover.other.service;

import com.gulincover.api.entity.EntryInfo;
import com.gulincover.other.dao.EntryInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryInfoRelatedService {
    @Autowired
    private EntryInfoMapper entryInfoMapper;

    public List<EntryInfo> inquireEntryInfoByTopicId(Long topicId) {
        return entryInfoMapper.selectEntryInfosByTopicId(topicId);
    }

//    public EntryInfo[] inquireEntryInfosByRelated2EntryByTopicId(Integer topicId) {
//        Integer[] entryIds = related2EntryMapper.selectEntryIdsByTopicId(topicId);
//        return inquireEntryInfosByEntryIds(entryIds);
//    }
//
//    public EntryInfo[] inquireEntryInfosByRelated2EntryByCommentId(Integer commentId) {
//        Integer[] entryIds = related2EntryMapper.selectEntryIdsByCommentId(commentId);
//        return inquireEntryInfosByEntryIds(entryIds);
//    }

    public EntryInfo[] inquireEntryInfosByEntryIds(Integer[] entryIds) {
        return entryInfoMapper.selectEntryInfosByEntryIds(entryIds);
    }

    public EntryInfo inquireEntryInfoByEntryId(Integer entryId) {
        return entryInfoMapper.selectEntryInfoByEntryId(entryId);
    }
}
