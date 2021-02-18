package com.gulincover.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;

@Data
public class LikeInfo implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    public Long id;
    public Long userId;
    public Long topicId;
    public Long commentId;
    public Long entryId;

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
