package com.gulincover.api.httpResp.displeasureResp;

import com.gulincover.api.HttpStateCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class PostDispleasureResp implements Serializable {
    private HttpStateCode httpStateCode;
}
