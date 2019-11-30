package com.streamslience.simples.metainfo.mpslautofillmetainfo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <h2>Title:自定义字段注入处理类</h2><br>
 * <h2>Description:</h2><br>
 * 对于实现自动注入的字段，前端不需要传值，<br>
 * 任何显示的赋值都将使自动注入失效，取而代之的值即为显示赋值的参数。<br>
 *
 * @author StreamSlience
 * @Date 2019/11/30-20:53
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * <p>新增自动注入</p>
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasGetter("createDate") && metaObject.hasGetter("updateDate")) {
            this.setFieldValByName("createDate", new Date(), metaObject);
            this.setFieldValByName("updateDate", new Date(), metaObject);
        }
    }

    /**
     * <p>更新自动注入</p>
     *
     * @param metaObject
     * @note mybatisPlus自带的update方法都对入参实体添加了注解@Param("et")<br>
     * 因此使用{@code metaObject.hasGetter("updateDate")} 为 false
     * 应该使用{@code metaObject.hasGetter("et.updateDate")} 才是正确方法
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter("et.updateDate")) {
            this.setFieldValByName("updateDate", new Date(), metaObject);
        }
    }
}
