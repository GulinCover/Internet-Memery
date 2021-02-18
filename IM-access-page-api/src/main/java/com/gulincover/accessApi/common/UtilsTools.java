package com.gulincover.accessApi.common;

import com.gulincover.accessApi.service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilsTools {
    @Autowired
    private UserPageService userPageService;

    public boolean isLogin(String id) {
        Long userIdById = userPageService.findUserIdById(Long.parseLong(id));
        if (userIdById == null || userIdById != 1) return false;
        return true;
    }
}
