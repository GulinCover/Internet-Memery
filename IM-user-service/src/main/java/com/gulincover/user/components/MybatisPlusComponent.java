package com.gulincover.user.components;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.gulincover.utils.tools.IdGenerator;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MybatisPlusComponent implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
//        strictInsertFill(metaObject, "user_id", Long.class, IdGenerator.nextId());
        strictInsertFill(metaObject, "create_date",Date.class, new Date());
        strictInsertFill(metaObject, "update_date",Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictUpdateFill(metaObject, "update_date",Date.class, new Date());
    }
}
