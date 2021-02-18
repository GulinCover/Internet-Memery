package com.gulincover.api.httpResp.userManagerPage;

import lombok.Data;

import java.util.List;

@Data
public class UserLoginInfoResp {
    private List<UserLoginInfo> userLoginInfoList;

    private String code;
}
