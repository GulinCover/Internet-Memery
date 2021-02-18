package com.gulincover.user.rpcService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@FeignClient(
        value = "service-other"
)
public interface RpcAuthCodeService {
    @GetMapping("/rpc/get/otherInfo/for/authCode/by/{date}")
    String getAuthCode(@PathVariable("date") Date date);
}
