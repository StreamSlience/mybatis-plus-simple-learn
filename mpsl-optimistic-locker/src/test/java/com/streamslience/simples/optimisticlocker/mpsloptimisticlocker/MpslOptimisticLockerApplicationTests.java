package com.streamslience.simples.optimisticlocker.mpsloptimisticlocker;

import com.streamslience.simples.optimisticlocker.mpsloptimisticlocker.dao.GoodsDao;
import com.streamslience.simples.optimisticlocker.mpsloptimisticlocker.entity.GoodsEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Console;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class MpslOptimisticLockerApplicationTests {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void version() {

        GoodsEntity goods_1 = new GoodsEntity();
        goods_1.setGoodsName("煤炭");
        goodsDao.insert(goods_1);

        goods_1.setGoodsName("还是一块煤炭");

        if (goodsDao.updateById(goods_1) == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

    }

}
