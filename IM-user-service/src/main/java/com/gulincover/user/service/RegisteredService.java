package com.gulincover.user.service;

import com.gulincover.api.entity.UserInfo;
import com.gulincover.api.httpReq.registerReq.RegisterUserAccessAbs;
import com.gulincover.user.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public Long isRepeatEmail(String email) {
        return userInfoMapper.findRepeatEmail(email);
    }

    public Long isRepeatPhone(String phone) {
        return userInfoMapper.findRepeatPhone(phone);
    }

    public Long isRepeatNickname(String name) {
        return userInfoMapper.findRepeatNickname(name);
    }

    public int insertUserInfoByEmail(RegisterUserAccessAbs form) {
        Long repeat = isRepeatEmail(form.getEmail());
        if (repeat == null || repeat >= 1) {
            return 0;
        }
        Long repeatName = isRepeatNickname(form.getName());
        if (repeatName == null || repeatName >= 1) {
            return 0;
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(form.getEmail());
        userInfo.setName(form.getName());
        userInfo.setPassword(form.getPassword());
        userInfo.setVersion(1);
        return userInfoMapper.insert(userInfo);
    }

    public int insertUserInfoByPhone(RegisterUserAccessAbs form) {
        Long repeat = isRepeatPhone(form.getPhone());
        if (repeat == null || repeat >= 1) {
            return 0;
        }
        Long repeatName = isRepeatNickname(form.getName());
        if (repeatName == null || repeatName >= 1) {
            return 0;
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setPhone(form.getPhone());
        userInfo.setName(form.getName());
        userInfo.setPassword(form.getPassword());
        userInfo.setVersion(1);
        return userInfoMapper.insert(userInfo);
    }

}
