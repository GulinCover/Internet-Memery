package com.gulincover.comment.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//@Component
public class SentinelGlobalRequestOriginParserHandler implements RequestOriginParser {
    @Value("service.identifier")
    private String identifierCode;

    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String parameter = httpServletRequest.getParameter("");
        if (StringUtil.isNullOrEmpty(parameter) || !identifierCode.equals(parameter)) {
            return "";
        }
        return parameter;
    }
}
