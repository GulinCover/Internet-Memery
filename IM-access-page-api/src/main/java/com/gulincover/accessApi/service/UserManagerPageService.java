package com.gulincover.accessApi.service;

import com.gulincover.api.httpResp.userManagerPage.UserLoginInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class UserManagerPageService {
    //用户头像上传
    public String postUpdateUploadUserAvatar(MultipartFile file) {
        return "";
    }
    //获取登录信息
    public List<UserLoginInfo> postSelectUserLoginInfo(Long userId) {
        return null;
    }

    //剔除某个登陆信息
    public Integer postDeleteSingleUserLoginInfo(Long userId, Map<String, String> form) {
        return 200;
    }

    public Long postSelectUserCoinNumber(Long userId) {
        return 0L;
    }
}
