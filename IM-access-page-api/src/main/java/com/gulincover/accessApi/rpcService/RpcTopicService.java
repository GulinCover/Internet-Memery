package com.gulincover.accessApi.rpcService;

import com.gulincover.api.entity.TopicInfo;
import com.gulincover.accessApi.rpcFallbackService.RpcTopicFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(
        value = "service-topic",
        fallbackFactory = RpcTopicFallbackService.class
)
public interface RpcTopicService {
    //是否结算
    @PostMapping(value = "/rpc/post/topic/is/settlement",produces = MediaType.APPLICATION_JSON_VALUE)
    Integer postIsTopicSettlement(Map<String, String> map);

    @PostMapping(value = "/rpc/post/settlement/topic",produces = MediaType.APPLICATION_JSON_VALUE)
    Integer postSettlementTopic(Map<String, String> map);

    @GetMapping("/rpc/get/topicInfo/exist/{id}")
    Integer isExist(@PathVariable("id") Long topicId);
    //获取著述信息
    @GetMapping("/rpc/get/topicInfo/{id}")
    TopicInfo inquireTopicInfo(@PathVariable("id") Long topicId);
}
