package com.gulincover.topic.rpcService;

import com.gulincover.api.entity.UserInfo;
import com.gulincover.topic.rpcFallbackService.RpcUserInfoFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "service-user",
        fallbackFactory = RpcUserInfoFallbackService.class
)
public interface RpcUserInfoService {

    @GetMapping("/rpc/get/userInfo/by/{userId}")
    UserInfo rpcGetUserInfoByUserId(@PathVariable("userId") Integer userId);
}
