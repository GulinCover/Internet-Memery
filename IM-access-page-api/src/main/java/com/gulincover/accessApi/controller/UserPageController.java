package com.gulincover.accessApi.controller;

import com.gulincover.accessApi.common.UtilsTools;
import com.gulincover.accessApi.service.UserPageService;
import com.gulincover.api.HttpStateCode;
import com.gulincover.api.httpResp.userPage.BrowseHistoryListResp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api("UserPageController")
@RestController
public class UserPageController {
    @Autowired
    private UtilsTools utilsTools;
    @Autowired
    private UserPageService userPageService;

    //用户信息完善
    /*
    可以完善的信息
    sex
    name
    age
    avatar
    desc
    phone
    email
    region
     */
    @PostMapping(value = "/api/post/userPage/for/perfect", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiPostUserInfoPerfect(@RequestHeader("id") String userId, @RequestBody Map<String, String> map) {
        if (!utilsTools.isLogin(userId))
            return HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString();
        map.put("id", userId);
        if (!userPageService.updateUserInfo(map))
            return HttpStateCode.CUSTOMIZE_OPERATION_FAILURE.toString();

        return HttpStateCode.OK.toString();
    }

    //建议提交功能
    @PostMapping(value = "/api/post/userPage/for/suggestions", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiPostSuggestions(@RequestHeader("id") String userId, @RequestBody Map<String, String> map) {
        if (!utilsTools.isLogin(userId))
            return HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString();

        if (!userPageService.insertSuggestions(Long.parseLong(userId), map.get("Content")))
            return HttpStateCode.CUSTOMIZE_OPERATION_FAILURE.toString();

        return HttpStateCode.OK.toString();
    }

    //获取浏览记录
    @PostMapping(value = "/api/post/userPage/for/browseHistory")
    public BrowseHistoryListResp apiPostBrowseHistory(@RequestHeader("id") String userId, Map<String, String> map) {
        BrowseHistoryListResp resp = new BrowseHistoryListResp();

        if (utilsTools.isLogin(userId)) {
            resp.setCode(HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString());
            return resp;
        }

        resp.setBrowseHistoryRespList(userPageService.selectBrowseHistory(userId, map.get("startPage")));
        resp.setCode(HttpStateCode.OK.toString());
        return resp;
    }
    //政策内容
    @PostMapping(value = "/api/post/userPage/for/policy")
    public String apiPolicyContent() {
        return userPageService.getPolicy();
    }
}














