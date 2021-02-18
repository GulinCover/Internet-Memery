package com.gulincover.comment.rpcService;

import com.gulincover.api.entity.EntryInfo;
import com.gulincover.api.httpResp.JsonReq.EntryInfosByCommentIdsAbs;
import com.gulincover.comment.rpcFallbackService.RpcEntryInfoFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(
        value = "service-other",
        fallbackFactory = RpcEntryInfoFallbackService.class
)
public interface RpcEntryInfoService {
    @PostMapping(value = "/rpc/post/entryInfos/by/commentIds")
    List<List<EntryInfo>> rpcPostEntryInfosByCommentIds(EntryInfosByCommentIdsAbs commentIds);
}
