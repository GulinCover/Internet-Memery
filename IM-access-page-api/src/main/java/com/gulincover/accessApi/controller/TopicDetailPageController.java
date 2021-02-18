package com.gulincover.accessApi.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

//著述详情页
@Api("TopicDetailPageController")
@RestController
public class TopicDetailPageController {
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

    //作者信息
    /*
    user_id,user_uuid,user_level,user_sex
     */

    //著述信息
    /*
    topic_id,topic_title,topic_desc,topic_content,topic_entries,topic_comment_number,topic_browse_number,topic_like_number,topic_create_time,topic_update_time
     */

    //普通一级评论信息
    /*
    comment1_id,comment1_content,comment1_entries,user_uuid,user_id,user_avatar,username,user_level,update_time
     */

    //普通二级评论信息
    /*
    comment2_id,comment2_content,comment2_entries,user_uuid,user_id,user_avatar,username,user_level,update_time
     */

    //获取0级质疑评论
    /*
    question_comment0_id,question_comment0_view,comment0_comment_number,comment0_like_number,comment0_displeasure_number
     */

    //质疑一级评论信息
    /*
    质疑的观点,comment1_id,comment1_content,comment1_entries,user_uuid,user_id,user_avatar,username,user_level,update_time
     */

    //质疑二级评论信息
    /*
    comment2_id,comment2_content,comment2_entries,user_uuid,user_id,user_avatar,username,user_level,update_time
     */

    //更具日,周,月获取浏览量,评论量
    /*
    comment_users,browse_users
    comment_users:user_id,user_uuid,username,user_avatar,user_level,comment_update_time
    browse_users:user_id,user_uuid,username,user_avatar,user_level,browse_update_time
     */



    //著述点赞
    //著述点踩
    //普票1级评论点赞
    //普票1级评论点踩
    //质疑0级评论点赞
    //质疑0级评论点赞
    //质疑1级评论点赞
    //质疑1级评论点踩
    //质疑2级评论点赞
    //质疑2级评论点踩
    /*
    需要提供:user_id,user_uuid,topic_id,及对应信息
     */

    //举报著述
    //举报普票1级评论
    //举报质疑0级评论
    //举报质疑1级评论
    /*
    需要提供:user_id,user_uuid,topic_id,举报理由,及对应信息
     */

    //发布普通一级评论
    /*
    需要提供:user_id,user_uuid,topic_id,comment1_content
     */

    //发布普通二级评论
    /*
    需要提供:user_id,user_uuid,topic_id,comment1_id,comment2_content
     */

    //发布质疑观点
    /*
    需要提供:user_id,user_uuid,topic_id,question_view
     */

    //发布质疑一级评论
    /*
    需要提供:user_id,user_uuid,topic_id,question_view,comment0_id,comment1_content
     */

    //发布质疑二级评论
    /*
    需要提供:user_id,user_uuid,topic_id,question_view,comment0_id,comment1_id,comment_official_entry_id,comment2_content
     */

    //发布著述
    /*
    需要提供:user_id,user_uuid,topic_title,topic_desc,topic_content,topic_entries
     */

    //著述追加内容;;;;;;;;;;隔断
    /*
    需要提供:user_id,user_uuid,topic_id
     */

}













