package com.gulincover.api.httpResp.loginPage;

import lombok.Data;

@Data
public class LoginResp {
    private Long userId;
    private String jwt;
    private String code;
}
