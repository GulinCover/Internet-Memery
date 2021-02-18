package com.gulincover.accessApi.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

//售卖物品的详细信息
@Api("MarketplaceDetailPageController")
@RestController
public class MarketplaceDetailPageController {
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

    //售卖人信息
    /*
    seller_id,seller_avatar,seller_name,seller_level,seller_uuid,seller_sex,seller_create_time,物品售卖时间
     */

    //售卖著述的信息
    /*
    topic_id,topic_title,topic_desc,竞价信息s,基础价格,当前最高价
    竞价信息s:user_id,user_uuid,user_level,bidding_price
     */
}












