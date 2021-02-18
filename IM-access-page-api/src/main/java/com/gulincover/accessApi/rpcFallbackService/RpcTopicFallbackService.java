package com.gulincover.accessApi.rpcFallbackService;

import com.gulincover.api.entity.TopicInfo;
import com.gulincover.accessApi.rpcService.RpcTopicService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RpcTopicFallbackService implements FallbackFactory<RpcTopicService> {
    @Override
    public RpcTopicService create(Throwable cause) {
        return new RpcTopicService() {
            @Override
            public Integer postIsTopicSettlement(Map<String, String> map) {
                return null;
            }

            @Override
            public Integer postSettlementTopic(Map<String, String> map) {
                return null;
            }

            @Override
            public Integer isExist(Long topicId) {
                return -1;
            }

            @Override
            public TopicInfo inquireTopicInfo(Long topicId) {
                return null;
            }
        };
    }
}
