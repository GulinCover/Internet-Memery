package com.gulincover.accessApi.controller;

import com.gulincover.accessApi.common.UtilsTools;
import com.gulincover.accessApi.service.AuctionPageService;
import com.gulincover.api.HttpStateCode;
import com.gulincover.api.entity.UserInfo;
import com.gulincover.api.httpResp.auctionPage.Bill;
import com.gulincover.api.httpResp.auctionPage.NicknameTopTenResp;
import com.gulincover.api.httpResp.auctionPage.TopicTopTenResp;
import com.gulincover.api.httpResp.common.UserInfoResp;
import com.gulincover.utils.tools.CovertToTools;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api("AuctionPage")
@RestController
public class AuctionPageController {
    @Value("${auction.page-number}")
    private Integer pageNumber;
    @Autowired
    private UtilsTools utilsTools;
    @Autowired
    private AuctionPageService auctionPageService;
    //词条著述数量查询
    

    //总成交额信息
    @GetMapping(value = "/a")
    public String apiSumTurnover() {
        return auctionPageService.getSumTurnover();
    }

    //用户信息
    @PostMapping(value = "/N")
    public UserInfoResp apiSelectUserInfo(@RequestHeader("id") String userId) {
        UserInfoResp userInfoResp = new UserInfoResp();
        if (utilsTools.isLogin(userId)) {
            userInfoResp.setCode(HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString());
            return userInfoResp;
        }

        final UserInfo userInfo = auctionPageService.postSelectUserInfo(CovertToTools.covertToLong(userId));
        if (userInfo == null) {
            userInfoResp.setCode(HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString());
            return userInfoResp;
        }
        userInfoResp.setUuid(userInfo.getUuid());
        userInfoResp.setAvatar(userInfo.getAvatar());
        userInfoResp.setLevel(userInfo.getUserLevel().toString());
        userInfoResp.setSex(userInfo.getSex().toString());
        userInfoResp.setUserId(userInfo.getId());
        userInfoResp.setCode(HttpStateCode.OK.toString());

        return userInfoResp;
    }

    //昵称上传拍卖
    @PostMapping(value = "/api/auction/upload/nickname", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiAuctionNickname(@RequestHeader("id") String userId, Map<String, String> form) {
        if (utilsTools.isLogin(userId))
            return HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString();
        form.put("user_id", userId);
        return auctionPageService.postAuctionNickname(form) == 200 ? HttpStateCode.OK.toString() : HttpStateCode.CUSTOMIZE_OPERATION_FAILURE.toString();
    }
    //著述上传拍卖
    @PostMapping(value = "/api/auction/upload/topic", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiAuctionTopic(@RequestHeader("id") String userId, Map<String, String> form) {
        if (utilsTools.isLogin(userId))
            return HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString();
        form.put("user_id", userId);
        return auctionPageService.postAuctionTopic(form) == 200 ? HttpStateCode.OK.toString() : HttpStateCode.CUSTOMIZE_OPERATION_FAILURE.toString();
    }
    //著述结算
    @PostMapping(value = "/api/settlement/topic", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiSettlementTopic(@RequestHeader("id") String userId, Map<String, String> form) {
        if (utilsTools.isLogin(userId))
            return HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString();
        form.put("userId", userId);
        return auctionPageService.postSettlementTopic(form) == 200 ? HttpStateCode.OK.toString() : HttpStateCode.CUSTOMIZE_OPERATION_FAILURE.toString();
    }

    //著述竞拍
    @PostMapping(value = "/api/bidding/topic", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiBiddingTopic(@RequestHeader("id") String userId, Map<String, String> form) {
        if (utilsTools.isLogin(userId))
            return HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString();
        form.put("user_id", userId);
        return auctionPageService.postBiddingTopic(form) == 200 ? HttpStateCode.OK.toString() : HttpStateCode.CUSTOMIZE_OPERATION_FAILURE.toString();
    }
    //昵称竞拍
    @PostMapping(value = "/api/bidding/nickname", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiBiddingNickname(@RequestHeader("id") String userId, Map<String, String> form) {
        if (utilsTools.isLogin(userId))
            return HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString();
        form.put("userId", userId);
        return auctionPageService.postBiddingNickname(form) == 200 ? HttpStateCode.OK.toString() : HttpStateCode.CUSTOMIZE_OPERATION_FAILURE.toString();
    }

    //使用昵称物品
    @PostMapping(value = "/api/use/nickname", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiUseNicknameConsumables(@RequestHeader("id") String userId, Map<String, String> form) {
        if (!utilsTools.isLogin(userId))
            return HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString();
        form.put("userId", userId);
        return auctionPageService.postUseNicknameConsumables(form) == 200 ? HttpStateCode.OK.toString() : HttpStateCode.CUSTOMIZE_USE_FAILURE.toString();
    }

    //使用著述物品
    @PostMapping(value = "/api/use/topic", produces = MediaType.APPLICATION_JSON_VALUE)
    public String apiUseTopicConsumables(@RequestHeader("id") String userId, Map<String, String> form) {
        if (!utilsTools.isLogin(userId))
            return HttpStateCode.CUSTOMIZE_NOT_REGISTER.toString();
        form.put("userId", userId);
        return auctionPageService.postUseTopicConsumables(form) == 200 ? HttpStateCode.OK.toString() : HttpStateCode.CUSTOMIZE_USE_FAILURE.toString();
    }

    //获取著述前十价格信息
    @GetMapping("/api/auction/topic/topTen")
    public TopicTopTenResp apiAuctionTopicTopTen() {
        TopicTopTenResp topicTopTenResp = new TopicTopTenResp();
        List<Bill> auctionTopicTopTen = auctionPageService.getAuctionTopicTopTen();
        if (auctionTopicTopTen == null || auctionTopicTopTen.isEmpty()) {
            topicTopTenResp.setCode(HttpStateCode.BAD_REQUEST.toString());
            return topicTopTenResp;
        }

        topicTopTenResp.setBillList(auctionTopicTopTen);
        topicTopTenResp.setCode(HttpStateCode.OK.toString());
        return topicTopTenResp;
    }

    //获取著述page后20个递增价格信息
    @GetMapping("/api/auction/topicTop/{page}")
    public TopicTopTenResp apiAuctionTopicTop(@PathVariable("page") Integer page) {
        TopicTopTenResp topicTopTenResp = new TopicTopTenResp();
        if (page > pageNumber) {
            topicTopTenResp.setCode(HttpStateCode.BAD_REQUEST.toString());
            return topicTopTenResp;
        }

        List<Bill> auctionTopicTopTen = auctionPageService.getAuctionTopicTop(page);
        if (auctionTopicTopTen == null || auctionTopicTopTen.isEmpty()) {
            topicTopTenResp.setCode(HttpStateCode.BAD_REQUEST.toString());
            return topicTopTenResp;
        }

        topicTopTenResp.setBillList(auctionTopicTopTen);
        topicTopTenResp.setCode(HttpStateCode.OK.toString());
        return topicTopTenResp;
    }

    //获取昵称前十价格信息
    @GetMapping("/api/auction/nickname/topTen")
    public NicknameTopTenResp apiAuctionNicknameTopTen() {
        NicknameTopTenResp nicknameTopTenResp = new NicknameTopTenResp();
        List<Bill> auctionNicknameTopTen = auctionPageService.getAuctionNicknameTopTen();
        if (auctionNicknameTopTen == null || auctionNicknameTopTen.isEmpty()) {
            nicknameTopTenResp.setCode(HttpStateCode.BAD_REQUEST.toString());
            return nicknameTopTenResp;
        }

        nicknameTopTenResp.setBillList(auctionNicknameTopTen);
        nicknameTopTenResp.setCode(HttpStateCode.OK.toString());
        return nicknameTopTenResp;
    }

    //获取昵称page后20个递增价格信息
    @GetMapping("/api/auction/nicknameTop/{page}")
    public NicknameTopTenResp apiAuctionNicknameTop(@PathVariable("page") Integer page) {
        NicknameTopTenResp nicknameTopTenResp = new NicknameTopTenResp();
        if (page > pageNumber) {
            nicknameTopTenResp.setCode(HttpStateCode.BAD_REQUEST.toString());
            return nicknameTopTenResp;
        }

        List<Bill> auctionNicknameTop = auctionPageService.getAuctionNicknameTop(page);
        if (auctionNicknameTop == null || auctionNicknameTop.isEmpty()) {
            nicknameTopTenResp.setCode(HttpStateCode.BAD_REQUEST.toString());
            return nicknameTopTenResp;
        }

        nicknameTopTenResp.setBillList(auctionNicknameTop);
        nicknameTopTenResp.setCode(HttpStateCode.OK.toString());
        return nicknameTopTenResp;
    }

}












