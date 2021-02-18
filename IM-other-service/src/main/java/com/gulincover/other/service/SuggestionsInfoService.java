package com.gulincover.other.service;

import com.gulincover.api.entity.SuggestionsInfo;
import com.gulincover.other.dao.SuggestionsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuggestionsInfoService {
    @Autowired
    private SuggestionsInfoMapper suggestionsInfoMapper;

    public Integer insertSuggestions(Long id, String content) {
        SuggestionsInfo suggestionsInfo = new SuggestionsInfo();
        suggestionsInfo.setUserId(id);
        suggestionsInfo.setContent(content);
        return suggestionsInfoMapper.insert(suggestionsInfo);
    }
}
