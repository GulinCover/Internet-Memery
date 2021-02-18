package com.gulincover.other.controller.authCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api("InquireAuthCodeApi")
@RestController
public class InquireAuthCodeApi {

    @ApiOperation("/rpc/get/otherInfo/for/authCode/by/{date}")
    @GetMapping("/rpc/get/otherInfo/for/authCode/by/{date}")
    public String getAuthCode(@PathVariable("date") Date date) {
        return "abs";
    }
}
