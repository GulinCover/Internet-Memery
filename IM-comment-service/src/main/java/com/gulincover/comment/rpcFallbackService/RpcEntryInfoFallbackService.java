package com.gulincover.comment.rpcFallbackService;

import com.gulincover.api.entity.EntryInfo;
import com.gulincover.api.httpResp.JsonReq.EntryInfosByCommentIdsAbs;
import com.gulincover.comment.rpcService.RpcEntryInfoService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RpcEntryInfoFallbackService implements FallbackFactory<RpcEntryInfoService> {
    @Override
    public RpcEntryInfoService create(Throwable cause) {
        return new RpcEntryInfoService() {
            @Override
            public List<List<EntryInfo>> rpcPostEntryInfosByCommentIds(EntryInfosByCommentIdsAbs commentIds) {
                EntryInfo entryInfo = new EntryInfo();
                entryInfo.setId(0L);
                List<EntryInfo> entryInfos = new LinkedList<>();
                List<List<EntryInfo>> entryInfoss = new LinkedList<>();
                entryInfos.add(entryInfo);
                entryInfoss.add(entryInfos);
                return entryInfoss;
            }
        };
    }
}
