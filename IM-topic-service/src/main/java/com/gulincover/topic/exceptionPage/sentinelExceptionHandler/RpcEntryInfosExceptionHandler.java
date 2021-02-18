package com.gulincover.topic.exceptionPage.sentinelExceptionHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

//@Service
public class RpcEntryInfosExceptionHandler {
    public static String blockHandler(Integer i, BlockException e) {
        return "RpcEntryInfosExceptionHandler.blockHandler";
    }

    public static String fallback(Integer i,Throwable e) {
        return "RpcEntryInfosExceptionHandler.fallback";
    }
}
