package com.gulincover.accessApi.rpcService;

import com.gulincover.api.entity.UserInfo;
import com.gulincover.accessApi.rpcFallbackService.RpcUserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(
        value = "service-user",
        fallbackFactory = RpcUserFallbackService.class
)
public interface RpcUserService {
    /*
    使用消耗品更改著述所有权
    id
    topic_id
     */
    @PostMapping("/rpc/post/use/topic/consumables")
    Integer postUseTopicConsumables(Map<String, String> map);
    /*
    使用消耗品更改昵称
    id
    new_name
     */
    @PostMapping("/rpc/post/use/nickname/consumables")
    Integer postUseNicknameConsumables(Map<String, String> map);
    /*
    注册
     */
    @PostMapping("/rpc/post/register")
    Integer register(Map<String, String> map);
    /*
    获取用户信息
     */
    @GetMapping("/rpc/get/userInfo/by/{userId}")
    UserInfo inquireUserInfo(@PathVariable("userId")Long userId);
    /*
    邮箱登陆
     */
    @PostMapping(value = "/rpc/post/userInfo/for/email/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    String postEmailLogin(Map<String, String> form);
    /*
    手机登陆
     */
    @PostMapping("/rpc/post/userInfo/for/phone/login")
    String postPhoneLogin(Map<String, String> form);
    /*
    用户是否存在
     */
    @GetMapping("/rpc/get/userInfo/for/userId/by/{userId}")
    Long getUserIdById(@PathVariable("userId")Long id);
    /*
    用户信息完善
     */
    @PostMapping("/rpc/post/userInfo/for/prefect/userInfo")
    Integer postPrefectUserInfo(Map<String, String> map);

}











