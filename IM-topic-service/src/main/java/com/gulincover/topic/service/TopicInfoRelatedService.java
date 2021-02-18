package com.gulincover.topic.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gulincover.api.entity.TopicInfo;
import com.gulincover.topic.dao.TopicInfoMapper;
import com.gulincover.utils.tools.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicInfoRelatedService {
    @Autowired
    private TopicInfoMapper topicInfoMapper;

    public Integer isExist(Long topicId) {
        Integer exist = topicInfoMapper.isExist(topicId);
        return exist == null ? -1 : exist;
    }

    public TopicInfo inquireTopicInfo(Long topicId) {
        return topicInfoMapper.selectById(topicId);
    }

//    public TopicInfo inquireTopicInfoByTopicInfoByTopicId(Integer topicId) {
//        return topicId <= 0 ? null : topicInfoMapper.selectTopicInfoByTopicId(topicId);
//    }

//    public Integer insetTopicInfo(Long userId, String topicName, String topicContent) {
//
//
////        TopicInfo topicInfo = topicInfoMapper.selectOne();
//        TopicInfo topicInfo = new TopicInfo();
////        topicInfo.id = 1338461231092137985L;
////        topicInfo.topicName = topicName;
////        topicInfo.content = topicContent;
//        topicInfo.userId = 6L;
////        topicInfo.topicId = 93567193446350848L;
////        topicInfo.topicId = IdGenerator.nextId();
//
////        Wrapper<TopicInfo> topicInfoWrapper = new QueryWrapper<>(topicInfo);
//
//        TopicInfo topicInfo2 = topicInfoMapper.selectOne(new QueryWrapper<>(topicInfo));
//        QueryWrapper<TopicInfo> q = new QueryWrapper<>();
//
////        TopicInfo topicInfo1 = new TopicInfo();
//        topicInfo2.topicName = topicName;
//        topicInfo2.content = topicContent;
//        topicInfo2.userId = userId;
//        topicInfo2.topicId = IdGenerator.nextId();
//        return topicInfoMapper.updateById(topicInfo2);
////        return null;
////        return topicInfoMapper.insert(topicInfo);
//    }
}
