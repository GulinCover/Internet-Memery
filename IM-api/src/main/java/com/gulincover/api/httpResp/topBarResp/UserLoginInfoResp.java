package com.gulincover.api.httpResp.topBarResp;

import lombok.Data;

@Data
public class UserLoginInfoResp {
    private Long userId;
    private String uuid;
    private String username;
    private String avatar;
    private String userDesc;
    private Long level;
    private Integer sex;

    private String code;
}
