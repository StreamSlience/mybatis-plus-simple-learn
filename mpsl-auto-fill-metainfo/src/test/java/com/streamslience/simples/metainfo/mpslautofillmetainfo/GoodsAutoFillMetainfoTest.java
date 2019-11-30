package com.streamslience.simples.metainfo.mpslautofillmetainfo;


import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.streamslience.simples.metainfo.mpslautofillmetainfo.dao.GoodsDao;
import com.streamslience.simples.metainfo.mpslautofillmetainfo.entity.GoodsEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h2>Title:物料信息自动注入测试类</h2><br>
 * <h2>Description:</h2><br>
 *
 * @author StreamSlience
 * @Date 2019/11/30-21:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class GoodsAutoFillMetainfoTest {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    @Order(1)
    public void insert() {
        goodsDao.insert(new GoodsEntity("我是一个物料新增"));
    }

    @Test
    @Order(2)
    public void update() {
        goodsDao.update(new GoodsEntity("我是一个物料修改"), new LambdaUpdateChainWrapper<>(goodsDao).eq(GoodsEntity::getGoodsName, "我是一个物料新增").getWrapper());
    }

    @Test
    @Order(3)
    public void delete() {
        goodsDao.delete(new LambdaQueryChainWrapper<>(goodsDao).getWrapper());
    }


}
