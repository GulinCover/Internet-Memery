package com.gulincover.other.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gulincover.api.entity.BrowseInfo;
import com.gulincover.api.httpReq.browseReq.PostBrowseInfoReq;
import com.gulincover.other.dao.BrowseInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowseInfoRelatedService {
    @Autowired
    private BrowseInfoMapper browseInfoMapper;

    public List<BrowseInfo> inquireTopicHistory(PostBrowseInfoReq req) {
        QueryWrapper<BrowseInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("userId", req.getUserId())
            .orderByDesc("update_date");

        Page<BrowseInfo> browseInfoIPage = browseInfoMapper.selectPage(new Page<>(req.getStart(), req.getEnd()), wrapper);

        return browseInfoIPage.getSize() > 0 ? browseInfoIPage.getRecords() : null;
    }

    public Integer publicTopicHistoryByBrowseInfo(Long userId,Long topicId) {
        QueryWrapper<BrowseInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId).eq("topic_id", topicId);
        Integer count = browseInfoMapper.selectCount(wrapper);
        BrowseInfo browseInfo = new BrowseInfo();
        if (count <= 0) {
            browseInfo = new BrowseInfo();
            browseInfo.setTopicId(topicId);
            return browseInfoMapper.insert(browseInfo);
        }
        browseInfo.setTopicId(topicId);
        return browseInfoMapper.update(browseInfo, wrapper);
    }

    public Integer publicUserHistoryByBrowseInfo(Long userId,Long user) {
        QueryWrapper<BrowseInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId).eq("browse_user_id", user);
        Integer count = browseInfoMapper.selectCount(wrapper);
        BrowseInfo browseInfo = new BrowseInfo();
        if (count <= 0) {
            browseInfo = new BrowseInfo();
            browseInfo.setTopicId(user);
            return browseInfoMapper.insert(browseInfo);
        }
        browseInfo.setTopicId(user);
        return browseInfoMapper.update(browseInfo, wrapper);
    }
}
