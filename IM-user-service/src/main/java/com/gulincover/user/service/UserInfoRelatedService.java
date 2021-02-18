package com.gulincover.user.service;

import com.gulincover.api.entity.UserInfo;
import com.gulincover.user.dao.User2SubscriptionMapper;
import com.gulincover.user.dao.UserInfoMapper;
import com.gulincover.utils.tools.CovertToTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserInfoRelatedService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private User2SubscriptionMapper user2SubscriptionMapper;

    public Long findUserIdByEmail(String email) {
        return userInfoMapper.selectIdByEmail(email);
    }

    public Long findUserIdByPhone(String phone) {
        return userInfoMapper.selectIdByPhone(phone);
    }

    public Long findUserIdById(Long id) {
        return userInfoMapper.selectUserIdById(id);
    }

    /*
    用户信息完善
     */
    public Integer updateUserInfo(Map<String, String> map) {
        UserInfo findUser = userInfoMapper.selectById(CovertToTools.covertToLong(map.get("id")));
        if (findUser == null) return -1;

        UserInfo userInfo = new UserInfo();
        userInfo.setId(CovertToTools.covertToLong(map.get("id")));
        /*
        为空才能更改
         */
        if (findUser.getEmail() == null)
            userInfo.setEmail(map.get("email"));
        if (findUser.getPhone() == null)
            userInfo.setPhone(map.get("phone"));
        if (findUser.getAge() == null)
            userInfo.setAge(CovertToTools.covertToInteger(map.get("age")));
        if (findUser.getName() == null)
            userInfo.setName(map.get("name"));
        if (findUser.getSex() == null)
            userInfo.setSex(CovertToTools.covertToInteger(map.get("sex")));
        if (findUser.getRegion() == null)
            userInfo.setRegion(map.get("region"));

        userInfo.setDescription(map.get("desc"));
        userInfo.setAvatar(map.get("avatar"));
        return userInfoMapper.updateById(userInfo);
    }

    /*
    new
     */


    public UserInfo inquireUserInfoByUserInfoByUserId(Long userId) {
        return userId <= 0 ? null : userInfoMapper.selectById(userId);
    }

    public Long loginEmail(String access, String password) {
        return userInfoMapper.loginByEmail(access, password);
    }

    public Long loginPhone(String access, String password) {
        return userInfoMapper.loginByPhone(access, password);
    }
}
