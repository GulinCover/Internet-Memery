package com.gulincover.comment.exceptionPage.sentinelExceptionHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.gulincover.api.httpResp.JsonReq.EntryInfosByCommentIdsAbs;
import org.springframework.stereotype.Service;

@Service
public class RpcEntryInfosExceptionHandler {
    public static String blockHandler(EntryInfosByCommentIdsAbs commentIds, BlockException e) {
        e.printStackTrace();
        return "RpcEntryInfosExceptionHandler.blockHandler";
    }

    public static String fallback(EntryInfosByCommentIdsAbs commentIds, Throwable e) {
        e.printStackTrace();
        return "RpcEntryInfosExceptionHandler.fallback";
    }
}
