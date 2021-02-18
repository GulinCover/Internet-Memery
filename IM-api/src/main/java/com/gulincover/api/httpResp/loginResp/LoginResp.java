package com.gulincover.api.httpResp.loginResp;

import lombok.Data;

@Data
public class LoginResp {
    private String code;
    private String jwt;
}
