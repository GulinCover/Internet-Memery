package com.gulincover.home.service.userRelated;

import com.gulincover.api.entity.UserInfo;
import com.gulincover.home.dao.User2SubscriptionMapper;
import com.gulincover.home.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoRelatedService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private User2SubscriptionMapper user2SubscriptionMapper;

    public UserInfo inquireUserInfoByUserInfoByUserId(Integer userId) {
        return userId <= 0 ? null : userInfoMapper.selectUserInfoByUserId(userId);
    }
}
