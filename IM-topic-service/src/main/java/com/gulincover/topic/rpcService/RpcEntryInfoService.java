package com.gulincover.topic.rpcService;

import com.gulincover.api.entity.EntryInfo;
import com.gulincover.topic.rpcFallbackService.RpcEntryInfoFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        value = "service-other",
        fallbackFactory = RpcEntryInfoFallbackService.class
)
public interface RpcEntryInfoService {
    @GetMapping(value = "/rpc/entry/entryInfos/by/topic/{topicId}")
    List<EntryInfo> rpcGetEntryInfosByTopicId(@PathVariable("topicId")Integer topicId);
}
