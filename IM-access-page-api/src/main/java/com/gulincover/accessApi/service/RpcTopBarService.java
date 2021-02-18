package com.gulincover.accessApi.service;

import com.gulincover.accessApi.rpcTopBarServiceAbs.SearchHistoryTopicAbs;
import com.gulincover.api.entity.BrowseInfo;
import com.gulincover.api.entity.TopicInfo;
import com.gulincover.api.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RpcTopBarService {
    //post查询登陆信息
    public UserInfo postSelectUserLoginInfo(Long userId) {
        return null;
    }

    //post查询attentionUserInfo表里关注的人最后发布的著述
    public List<Long> postSelectNotification(Long userId) {
        return null;
    }

    //post查询浏览器记录,最近5条
    public List<SearchHistoryTopicAbs> postSelectSearchHistory(Long userId) {
        return null;
    }
}
