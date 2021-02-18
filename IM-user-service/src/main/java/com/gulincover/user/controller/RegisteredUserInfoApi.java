package com.gulincover.user.controller;

import com.gulincover.api.HttpStateCode;
import com.gulincover.api.httpReq.registerReq.RegisterUserAccessAbs;
import com.gulincover.user.service.RegisteredService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api("RegisteredUserInfoApi")
@RestController
public class RegisteredUserInfoApi {
    @Autowired
    private RegisteredService registeredService;

    /*
    api
     */
    @ApiOperation("/api/phone/register/access")
    @PostMapping(value = "/api/email/register/access", produces = MediaType.APPLICATION_JSON_VALUE)
    public String emailRegisterPostUserAccessApi(@RequestBody RegisterUserAccessAbs form) {
        if (hasEmpty(form)) {
            return HttpStateCode.PARAMETER_NOT_INTACT.toString();
        }
        int id = registeredService.insertUserInfoByEmail(form);
        if (id == 0) {
            return HttpStateCode.CUSTOMIZE_REGISTER_EMAIL_REPEAT.toString();
        }
        return HttpStateCode.CUSTOMIZE_REGISTER_SUCCESS.toString();
    }

    @ApiOperation("/api/phone/register/access")
    @PostMapping(value = "/api/phone/register/access", produces = MediaType.APPLICATION_JSON_VALUE)
    public String phoneRegisterPostUserAccessApi(@RequestBody RegisterUserAccessAbs form) {
        if (hasEmpty(form)) {
            return HttpStateCode.PARAMETER_NOT_INTACT.toString();
        }
        int id = registeredService.insertUserInfoByPhone(form);
        if (id == 0) {
            return HttpStateCode.CUSTOMIZE_REGISTER_PHONE_REPEAT.toString();
        }
        return HttpStateCode.CUSTOMIZE_REGISTER_SUCCESS.toString();
    }

    @ApiOperation("/api/select/email/{email}")
    @GetMapping("/api/select/email/{email}")
    public String isRepeatEmail(@PathVariable("email") String email) {
        if (registeredService.isRepeatEmail(email) == null && registeredService.isRepeatEmail(email) <= 1)
            return HttpStateCode.CUSTOMIZE_REGISTER_EMAIL_NOT_REPEAT.toString();
        return HttpStateCode.CUSTOMIZE_REGISTER_EMAIL_REPEAT.toString();
    }

    @ApiOperation("/api/select/phone/{phone}")
    @GetMapping("/api/select/phone/{phone}")
    public String isRepeatPhone(@PathVariable("phone") String phone) {
        if (registeredService.isRepeatEmail(phone) == null && registeredService.isRepeatPhone(phone) <= 1)
            return HttpStateCode.CUSTOMIZE_REGISTER_PHONE_NOT_REPEAT.toString();
        return HttpStateCode.CUSTOMIZE_REGISTER_PHONE_REPEAT.toString();
    }

    @ApiOperation("/api/select/name/{name}")
    @GetMapping("/api/select/name/{name}")
    public String isRepeatNickname(@PathVariable("name") String name) {
        if (registeredService.isRepeatEmail(name) == null && registeredService.isRepeatNickname(name) <= 1)
            return HttpStateCode.CUSTOMIZE_REGISTER_NICKNAME_NOT_REPEAT.name();
        return HttpStateCode.CUSTOMIZE_REGISTER_NICKNAME_REPEAT.toString();
    }

    /*
    rpc
     */

    /*
    utils
     */
    private boolean hasEmpty(RegisterUserAccessAbs r) {
        if (r.getName().isEmpty() ||
                r.getPassword().isEmpty() ||
                (r.getEmail().isEmpty() && r.getPhone().isEmpty())
        ) {
            return true;
        }
        return false;
    }


    /*
    test
     */
}













