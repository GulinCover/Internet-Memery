package com.gulincover.home.service.topicRelated;

import com.gulincover.api.entity.TopicInfo;
import com.gulincover.home.dao.TopicInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicInfoRelatedService {
    @Autowired
    private TopicInfoMapper topicInfoMapper;

    public TopicInfo inquireTopicInfoByTopicInfoByTopicId(Integer topicId) {
        return topicId <= 0 ? null : topicInfoMapper.selectTopicInfoByTopicId(topicId);
    }
}
