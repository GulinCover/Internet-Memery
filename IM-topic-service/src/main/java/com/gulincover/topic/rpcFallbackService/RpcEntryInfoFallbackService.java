package com.gulincover.topic.rpcFallbackService;

import com.gulincover.api.entity.EntryInfo;
import com.gulincover.topic.rpcService.RpcEntryInfoService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/*
容错类
远程调用失败
调用此方法
 */
@Service
public class RpcEntryInfoFallbackService implements FallbackFactory<RpcEntryInfoService> {
    @Override
    public RpcEntryInfoService create(Throwable cause) {
        return new RpcEntryInfoService() {
            @Override
            public List<EntryInfo> rpcGetEntryInfosByTopicId(Integer topicId) {
                cause.printStackTrace();
                List<EntryInfo> entryInfos = new LinkedList<>();
                EntryInfo entryInfo = new EntryInfo();
                entryInfo.setId(0L);
                entryInfo.setContent("error");
                entryInfo.setLikeNumber(0);
                entryInfos.add(entryInfo);
                return entryInfos;
            }
        };
    }
}
