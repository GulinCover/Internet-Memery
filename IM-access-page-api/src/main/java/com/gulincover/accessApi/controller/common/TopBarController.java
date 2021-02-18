package com.gulincover.accessApi.controller.common;

import com.gulincover.accessApi.rpcTopBarServiceAbs.SearchHistoryTopicAbs;
import com.gulincover.accessApi.service.RpcTopBarService;
import com.gulincover.api.HttpStateCode;
import com.gulincover.api.entity.BrowseInfo;
import com.gulincover.api.entity.SearchHistoryInfo;
import com.gulincover.api.entity.UserInfo;
import com.gulincover.api.httpResp.topBarResp.InfoNotificationResp;
import com.gulincover.api.httpResp.topBarResp.TopicSearchHistoryAbs;
import com.gulincover.api.httpResp.topBarResp.TopicSearchHistoryResp;
import com.gulincover.api.httpResp.topBarResp.UserLoginInfoResp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Api("TopBarController")
@RestController
public class TopBarController {
    @Autowired
    private RpcTopBarService rpcTopBarService;

    //用户登陆信息
    /*
    user_uuid,username,avatar,desc,level,sex
     */
    public UserLoginInfoResp postSelectUserLoginInfoApi(@RequestHeader("userId") Long userId) {
        UserLoginInfoResp resp = new UserLoginInfoResp();
        UserInfo userInfo = rpcTopBarService.postSelectUserLoginInfo(userId);
        if (Objects.isNull(userInfo)) {
            resp.setCode(HttpStateCode.CUSTOMIZE_OPERATION_FAILURE.toString());
            return resp;
        }

        resp.setUserId(userInfo.getId());
        resp.setAvatar(userInfo.getAvatar());
        resp.setLevel(userInfo.getUserLevel());
        resp.setSex(userInfo.getSex());
        resp.setUserDesc(userInfo.getDescription());
        resp.setUsername(userInfo.getName());
        resp.setUuid(userInfo.getUuid());

        resp.setCode(HttpStateCode.OK.toString());
        return resp;
    }

    //信息通知
    /*
    topic_number,private_chart_number
     */
    public InfoNotificationResp postSelectNotificationApi(@RequestHeader("userId") Long userId) {
        InfoNotificationResp resp = new InfoNotificationResp();

        List<Long> longs = rpcTopBarService.postSelectNotification(userId);
        resp.setAttentionTopicIds(longs);

        resp.setCode(HttpStateCode.OK.toString());
        return resp;
    }

    //搜索浏览历史
    /*
    topics
    topics:topic_id,topic_title
     */
    public TopicSearchHistoryResp postSelectSearchHistoryApi(@RequestHeader("userId") Long userId) {
        TopicSearchHistoryResp resp = new TopicSearchHistoryResp();

        List<SearchHistoryTopicAbs> searchHistoryTopicAbs = rpcTopBarService.postSelectSearchHistory(userId);
        if (Objects.isNull(searchHistoryTopicAbs)) {
            resp.setCode(HttpStateCode.CUSTOMIZE_OPERATION_FAILURE.toString());
            return resp;
        }

        resp.setUserId(userId);
        List<TopicSearchHistoryAbs> searchHistoryList = new LinkedList<>();

        searchHistoryTopicAbs.forEach((item)->{
            TopicSearchHistoryAbs topicSearchHistoryAbs = new TopicSearchHistoryAbs();
            topicSearchHistoryAbs.setTopicId(item.getTopicId());
            topicSearchHistoryAbs.setTopicTitle(item.getTopicTitle());
        });
        resp.setSearchHistoryList(searchHistoryList);

        resp.setCode(HttpStateCode.OK.toString());
        return resp;
    }
}



