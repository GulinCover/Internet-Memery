package com.gulincover.comment.exceptionPage;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.gulincover.api.HttpStateCode;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class SentinelGlobalExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        HttpStateCode httpStateCode;
        if (e instanceof FlowException) {
            httpStateCode = HttpStateCode.SENTINEL_FLOW;
        } else if (e instanceof DegradeException) {
            httpStateCode = HttpStateCode.SENTINEL_DEGRADE;
        } else if (e instanceof ParamFlowException) {
            httpStateCode = HttpStateCode.SENTINEL_PARAM_FLOW;
        } else if (e instanceof AuthorityException) {
            httpStateCode = HttpStateCode.SENTINEL_AUTHORITY;
        } else if (e instanceof SystemBlockException) {
            httpStateCode = HttpStateCode.SENTINEL_SYSTEM_BLOCK;
        } else {
            httpStateCode = HttpStateCode.UNKNOWN_EXCEPTION;
        }

        httpServletResponse.getWriter().write(httpStateCode.toString());
    }
}
