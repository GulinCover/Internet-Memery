package com.gulincover.accessApi.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

@Api("TopicPageController")
@RestController
public class HotPageController {
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

    //热论#话题排行,热点著述不能拍卖和获取收益
    /*
    topic_id,topic_desc,topic_title,topic_entries,topic_like_number,update_time,create_time
     */

    //搜索
    /*
    可以根据时间,热论#内容,名称模糊搜索
     */
}













