package com.gulincover.api.httpResp.common;

import lombok.Data;

@Data
public class UserInfoResp {
    private Long userId;
    private String level;
    private String uuid;
    private String sex;
    private String avatar;
    private String code;
}
