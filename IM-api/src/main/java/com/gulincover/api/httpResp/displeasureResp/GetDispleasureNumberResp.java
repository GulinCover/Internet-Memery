package com.gulincover.api.httpResp.displeasureResp;

import com.gulincover.api.HttpStateCode;
import lombok.Data;

@Data
public class GetDispleasureNumberResp {
    private HttpStateCode httpStateCode;
    private Integer number;
}
