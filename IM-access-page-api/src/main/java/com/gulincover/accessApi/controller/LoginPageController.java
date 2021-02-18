package com.gulincover.accessApi.controller;

import com.gulincover.api.HttpStateCode;
import com.gulincover.api.httpReq.loginReq.LoginReq;
import com.gulincover.api.httpResp.loginResp.LoginResp;
import com.gulincover.accessApi.service.LoginPageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api("LoginPageController")
@RestController
public class LoginPageController {

    @Autowired
    private LoginPageService loginPageService;

    @ApiOperation("/api/user/login")
    @PostMapping(value = "/api/user/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResp apiPostLogin(@RequestBody LoginReq req) {
        LoginResp loginResp = new LoginResp();
        if (req == null ||
                req.getAccess() == null ||
                req.getLoginType() == null ||
                req.getPassword() == null
        ) {
            loginResp.setCode(HttpStateCode.CUSTOMIZE_LOGIN_FAILURE.toString());
            return loginResp;
        }
        String jwt = "";
        if (req.getLoginType().equals("email")) {
            jwt = loginPageService.emailLogin(req.getAccess(), req.getPassword());
        } else if (req.getLoginType().equals("phone")) {
            jwt = loginPageService.phoneLogin(req.getAccess(), req.getPassword());
        } else {
            loginResp.setCode(HttpStateCode.CUSTOMIZE_LOGIN_FAILURE.toString());
            return loginResp;
        }
        if (jwt == null || jwt.equals("")) {
            loginResp.setCode(HttpStateCode.CUSTOMIZE_LOGIN_FAILURE.toString());
            return loginResp;
        }
        loginResp.setJwt(jwt);
        loginResp.setCode(HttpStateCode.OK.toString());
        return loginResp;
    }
}












