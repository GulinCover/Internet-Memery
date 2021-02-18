package com.gulincover.api.httpReq.loginReq;

import lombok.Data;

@Data
public class LoginReq {
    private String access;
    private String password;
    private String loginType;
}
