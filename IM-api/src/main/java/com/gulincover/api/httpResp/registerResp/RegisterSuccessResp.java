package com.gulincover.api.httpResp.registerResp;

import com.gulincover.api.HttpStateCode;
import lombok.Data;

@Data
public class RegisterSuccessResp {
    private String httpStateCode;
    private String token;
}
