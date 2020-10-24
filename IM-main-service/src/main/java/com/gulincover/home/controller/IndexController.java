package com.gulincover.home.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "test clazz")
@RestController
public class IndexController {

    @ApiOperation("test methods")
    @GetMapping("/")
    public String test() {
        return "ok";
    }

    @ApiOperation("test methods")
    @GetMapping("/test")
    public String test2() {
        return "test2";
    }

}
