package com.gulincover.accessApi.controller;

import com.gulincover.accessApi.service.RegisterPagerService;
import com.gulincover.api.HttpStateCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("RegisterPageController")
@RestController
public class RegisterPageController {
    @Autowired
    private RegisterPagerService registerPagerService;

    //邮箱注册
    @ApiOperation("/api/post/email/register")
    @PostMapping(value = "/api/post/email/register",produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiEmailRegister(@RequestBody Map<String, String> form) {
        form.put("type", "email");
        return registerPagerService.register(form) == 200 ? HttpStateCode.OK.toString() : HttpStateCode.CUSTOMIZE_REGISTER_EMAIL_FAILURE.toString();
    }
    //电话注册
    @ApiOperation("/api/post/phone/register")
    @PostMapping(value = "/api/post/phone/register",produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiPhoneRegister(@RequestBody Map<String, String> form) {
        form.put("type", "phone");
        return registerPagerService.register(form) == 200 ? HttpStateCode.OK.toString() : HttpStateCode.CUSTOMIZE_REGISTER_EMAIL_FAILURE.toString();
    }
}
