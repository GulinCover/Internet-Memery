package com.gulincover.gateway.config.mybatisPlusConfig;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GlobalMybatisPlusConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "create_time", Date.class, new Date());
        strictInsertFill(metaObject, "update_time", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictUpdateFill(metaObject, "update_time", Date.class, new Date());
    }
}
