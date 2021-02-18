package com.gulincover.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    public Long id;
    public String uuid;//用户显示名
    public String password;
    public Integer sex;
    public String name;
    public Integer age;
    public String avatar;
    public String description;

    public String loginMark;//登陆标记,踢除现已登陆的jwt时使用
    public String newLoginMark;//new为8,loginMark为10.剔除loginMark为2的jwt
    public String formerName;//曾用名 ;Alex;tony;
    public String phone;
    public String email;
    public Long userLevel;
    public String authority;
    public String region;//地区 ;中国;北京;长街;
    public Integer modifications;//赠送的昵称更改次数，默认1

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
