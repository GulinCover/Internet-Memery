package com.gulincover.api.httpReq.registerReq;

import lombok.Data;

@Data
public class RegisterUserAccessAbs {
    private String password = "";
    private String name = "";
    private String email = "";
    private String phone = "";
}
