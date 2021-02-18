package com.gulincover.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulincover.api.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    Long findRepeatEmail(String email);
    Long findRepeatPhone(String phone);
    Long findRepeatNickname(String name);
    Long loginByEmail(String email, String password);
    Long loginByPhone(String phone, String password);


    Long selectIdByEmail(String email);
    Long selectIdByPhone(String phone);
    Long selectUserIdById(Long id);
}
