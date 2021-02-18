package com.gulincover.accessApi.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

@Api("TopicPageController")
@RestController
public class TopicPageController {
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

    //获取板块信息
    /*
    entries,
    entries:entry_id,entry_content,entry_like_number,entry_desc
     */

    //板块推荐随机8到13条

    //板块词条的相关站外连接和创建时间

    //对应著述随机展示20条
    /*
    topics,
    topics:topic_id,topic_title,topic_desc,topic_like_number,topic_official_entries,topic_nonofficial_entries,update_time,user_id,username,user_level,user_sex
     */

    //随机获取一条普通评论
    /*
    user_id,username,user_avatar,comment1_id,comment1_content,comment1_entries,comment_time,comment2_number
     */

    //随机获取一条质疑评论
    /*
    user_id,username,user_avatar,question_content,comment1_id,comment1_content,comment1_entries,comment_time,comment2_number
     */

    //搜索
    /*
    可以根据时间,词条,名称模糊搜索,desc模糊搜索,普通评论模糊搜索,质疑评论模糊搜索
     */
}











