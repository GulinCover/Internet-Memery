package com.gulincover.home.httpRespImpl;

import com.gulincover.api.httpResp.CommonResp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CommonHttpRespImpl extends CommonResp {
    public HttpStatus httpStatusCode;

}
