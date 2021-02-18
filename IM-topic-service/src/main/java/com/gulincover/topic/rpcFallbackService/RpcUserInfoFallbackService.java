package com.gulincover.topic.rpcFallbackService;

import com.gulincover.topic.rpcService.RpcUserInfoService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

@Service
public class RpcUserInfoFallbackService implements FallbackFactory<RpcUserInfoService> {
    @Override
    public RpcUserInfoService create(Throwable cause) {
        return null;
    }
}
