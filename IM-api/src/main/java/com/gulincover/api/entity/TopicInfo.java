package com.gulincover.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TopicInfo implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    public Long id;
    public Long userId;
    public String userUuid;
    public String desc;
    public String topicName;
    public String content;

    public String isSettlement;//是否结算
    public String opinions;//意向
    public String entryList;//;1;2;3;4;5;213;

    public Integer commentNumber;//评论量
    public Integer likeNumber;//点赞量
    public Integer browseNumber;//浏览量
    public Integer shareNumber;//点踩量
    public Integer favoritesNumber;//分享量

    public Integer sumCommentNumber;//总评论量
    public Integer sumLikeNumber;//总点赞量
    public Integer sumBrowseNumber;//总浏览量
    public Integer sumDispleasureNumber;//总点踩量
    public Integer sumShareNumber;//总分享量
    public Integer sumFavoritesNumber;//总收藏量

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date createDate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date updateDate;
    @Version
    public Integer version;
    @TableLogic
    public Integer isBlack;
}
