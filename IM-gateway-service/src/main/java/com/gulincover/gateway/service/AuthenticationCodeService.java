package com.gulincover.gateway.service;

import com.gulincover.gateway.dao.AuthenticationCodeMapper;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationCodeService {
    @Autowired
    private AuthenticationCodeMapper authenticationCodeMapper;

    public boolean isValid(String code) {
        if (StringUtil.isNullOrEmpty(code)) return false;

//        return authenticationCodeMapper.isExistByAuthenticationCode(code);
        if ("test-test-test-test".equals(code))
            return true;
        return false;
    }

    public String anonymousAccess() {
        return "anonymous-access-beta-alpha";
    }
}
