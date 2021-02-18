package com.gulincover.home.rpcService;

import com.gulincover.api.entity.EntryInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-other")
public interface RpcEntryInfoService {
    @RequestMapping(value = "/rpc/entry/entryInfos/by/{topicId}",method = {RequestMethod.GET})
    EntryInfo[] rpcGetEntryInfosByTopicId(@PathVariable("topicId")Integer topicId);
}
