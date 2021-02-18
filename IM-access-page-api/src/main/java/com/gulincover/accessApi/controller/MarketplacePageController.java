package com.gulincover.accessApi.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

@Api("MarketplacePageController")
@RestController
public class MarketplacePageController {
    //用户登陆信息
    /*
    user_uuid,username,avatar,desc,level,sex
     */

    //信息通知
    /*
    topic_number,private_chart_number
     */

    //搜索历史
    /*
    topic_id,topic_title
     */

    //板块分类
    /*
    entries
     */

    //根据板块显示售卖著述信息
    /*
    根据起始页和数量显示
    entry_id,entry_content,bills
    bills:bill_id,user_id,user_uuid,user_avatar,topic_id,topic_title,topic_desc
     */

    //根据板块显示售卖昵称信息
    /*
    根据起始页和数量显示
    bills
    bills:bill_id,user_id,user_uuid,user_avatar,nickname
     */
}










