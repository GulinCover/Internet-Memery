package com.gulincover.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BillInfo {
    @TableId(type = IdType.ASSIGN_UUID)
    private Long id;
    private Long buyer;
    private Long seller;
    private String type;
    private Long price;
    private Long basePrice;
    private String content;
    private Long contentId;
    private Integer cycle;//售卖周期,最高1周//0到7

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date createDate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date updateDate;
    @Version
    public Integer version;
    @TableLogic
    public Integer isBlack;
}
