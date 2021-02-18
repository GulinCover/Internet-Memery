package com.gulincover.accessApi.controller;

import com.gulincover.api.HttpStateCode;
import com.gulincover.api.httpResp.topBarResp.InfoNotificationResp;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//综合推荐页
@Api("ExplorePageController")
@RestController
public class ExplorePageController {
    //随机本版推荐,每个板块随机3到5条topic内容
    /*
    entry_id,entry,entry_desc,topics,
    topics:topic_id,topic_title,topic_desc,topic_like_number,user_id,username,user_level
     */

    //随机话题推荐,每个话题随机3到5条topic内容
    /*
    entry_id,hot_entry,entry_desc,topics,
    topics:topic_id,topic_title,topic_desc,topic_like_number,user_id,username,user_level
     */

    //随机昵称售卖推荐,每个昵称随机5到10条昵称售卖信息
    /*
    hot,nickname_auctions,
    nickname_auctions:bill,
    bill:bill_id,user_id,user_uuid,content,price
     */


    //随机著述售卖推荐,每个著述随机5到10条著述售卖信息
    /*
    hot,nickname_auctions,
    nickname_auctions:bill,
    bill:bill_id,user_id,user_uuid,content,price
    content:topic_id,topic_title,topic_desc
     */

    //可能感兴趣的标签推荐
    /*
    entry_id,entry_url,entry,entry_desc,related_entries
    related_entries:entry_id,entry
     */

    //单标签推荐
    /*
    entry_id,entry_url,entry,entry_desc
     */

    //昨日著述随机5到10
    /*
    entry_id,entry,entry_desc,entry_like_number,topics
    topics:topic_id,topic_title,topic_desc,topic_like_number
     */

    //昨日hot随机5到10
    /*
    hot_entry_id,entry,entry_desc,entry_like_number,topics
    topics:topic_id,topic_title,topic_desc,topic_like_number
     */
}










