package com.streamslience.simples.page.mpslpage;

import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.streamslience.simples.page.mpslpage.dao.GoodsDao;
import com.streamslience.simples.page.mpslpage.entity.GoodsEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class MpslPageApplicationTests {


    @Autowired
    private GoodsDao goodsDao;

    @Test
    void contextLoads() {
    }

    /**
     * <p>MP自带CRUD分页</p>
     */
    @Test
    public void crudPage() {
        Console.print("新增数据");
        for (int i = 0; i < 20; ++i) {
            GoodsEntity goods = new GoodsEntity();
            goods.setGoodsName("物料" + i);
            goodsDao.insert(goods);
        }

        Console.print("MP自带CRUD方法进行分页查询");
        Page page = new Page(1, 2);
        IPage<GoodsEntity> goodsPage = goodsDao.selectPage(page, new LambdaQueryChainWrapper<>(goodsDao).getWrapper());
        goodsPage.getRecords().forEach(System.out::println);

        Console.print("删除所有数据");
        goodsDao.delete(new LambdaQueryChainWrapper<>(goodsDao).getWrapper());
    }

    /**
     * <p>自定义sql实现分页查询</p>
     */
    @Test
    public void xmlPage() {
        Console.print("新增数据");
        for (int i = 0; i < 20; ++i) {
            GoodsEntity goods = new GoodsEntity();
            goods.setGoodsName("物料" + i);
            goodsDao.insert(goods);
        }

        Console.print("自定义sql进行分页查询");
        Page page = new Page(1, 2);
        IPage<GoodsEntity> goodsPage = goodsDao.getGoods(page);
        goodsPage.getRecords().forEach(System.out::println);

        Console.print("删除所有数据");
        goodsDao.delete(new LambdaQueryChainWrapper<>(goodsDao).getWrapper());
    }

}
