package com.github.w4o.manage.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author frank
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("lastUpdateTime", LocalDateTime.now(), metaObject);
        //this.setFieldValByName("createBy", userInfo.getUserId(), metaObject);
        //this.setFieldValByName("updateBy", userInfo.getUserId(), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.setFieldValByName("lastUpdateTime", LocalDateTime.now(), metaObject);
        //this.setFieldValByName("updateBy", userInfo.getUserId(), metaObject);
    }
}