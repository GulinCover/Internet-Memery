package com.gulincover.home.service.otherRelated;

import com.gulincover.api.entity.EntryInfo;
import com.gulincover.home.dao.EntryInfoMapper;
import com.gulincover.home.dao.Related2EntryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryInfoRelatedService {
    @Autowired
    private EntryInfoMapper entryInfoMapper;
    @Autowired
    private Related2EntryMapper related2EntryMapper;

    public EntryInfo[] inquireEntryInfosByRelated2EntryByTopicId(Integer topicId) {
        Integer[] entryIds = related2EntryMapper.selectEntryIdsByTopicId(topicId);
        return inquireEntryInfosByEntryIds(entryIds);
    }

    public EntryInfo[] inquireEntryInfosByRelated2EntryByCommentId(Integer commentId) {
        Integer[] entryIds = related2EntryMapper.selectEntryIdsByCommentId(commentId);
        return inquireEntryInfosByEntryIds(entryIds);
    }

    public EntryInfo[] inquireEntryInfosByEntryIds(Integer[] entryIds) {
        return entryInfoMapper.selectEntryInfosByEntryIds(entryIds);
    }

    public EntryInfo inquireEntryInfoByEntryId(Integer entryId) {
        return entryInfoMapper.selectEntryInfoByEntryId(entryId);
    }
}
