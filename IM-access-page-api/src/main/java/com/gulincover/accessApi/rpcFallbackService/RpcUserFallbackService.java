package com.gulincover.accessApi.rpcFallbackService;

import com.gulincover.api.entity.UserInfo;
import com.gulincover.accessApi.rpcService.RpcUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RpcUserFallbackService implements FallbackFactory<RpcUserService> {
    @Override
    public RpcUserService create(Throwable cause) {
        return new RpcUserService() {
            @Override
            public Integer postUseTopicConsumables(Map<String, String> map) {
                return null;
            }

            @Override
            public Integer postUseNicknameConsumables(Map<String, String> map) {
                return null;
            }

            @Override
            public Integer register(Map<String, String> map) {
                return null;
            }

            @Override
            public UserInfo inquireUserInfo(Long userId) {
                return null;
            }

            @Override
            public String postEmailLogin(Map<String, String> form) {
                return null;
            }

            @Override
            public String postPhoneLogin(Map<String, String> form) {
                return null;
            }

            @Override
            public Long getUserIdById(Long id) {
                return null;
            }

            @Override
            public Integer postPrefectUserInfo(Map<String, String> map) {
                return null;
            }

        };
    }
}
