package com.gulincover.gateway.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulincover.api.entity.AuthenticationCodeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface AuthenticationCodeMapper extends BaseMapper<AuthenticationCodeEntity> {
    boolean isExistByAuthenticationCode(String code);

    String selectSigningKeyByCurrentDate(Date current);
}
