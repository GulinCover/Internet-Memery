package com.gulincover.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QuestionCommentInfo implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    public Long id;
    public Long userId;
    public Long commentId;
    public Long topicId;
    public String commentContent;

    public String questionView;//质疑点

    public String entryList;//;1;2;3;4;5;213;
    public Integer commentLevel;//0表示一级评论,1表示二级评论,2表示三级评论

    public Integer likeNumber;
    public Integer displeasureNumber;
    public Integer lastCommentNumber;

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
