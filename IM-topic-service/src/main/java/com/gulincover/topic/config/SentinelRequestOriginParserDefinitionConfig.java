package com.gulincover.topic.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//全局授权限制
//@Component
public class SentinelRequestOriginParserDefinitionConfig implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String serviceName = httpServletRequest.getParameter("serviceName");
        if (StringUtil.isNullOrEmpty(serviceName) || !"pc".equals(serviceName)) {
            throw new RuntimeException("参数错误！");
        }
        return serviceName;
    }
}
