package com.gulincover.accessApi.rpcFallbackService;

import com.gulincover.accessApi.rpcService.RpcCommentService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

@Service
public class RpcCommentFallbackService implements FallbackFactory<RpcCommentService> {
    @Override
    public RpcCommentService create(Throwable cause) {
        return null;
    }
}
