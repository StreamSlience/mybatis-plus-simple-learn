package com.streamslience.simples.sqlparser.mpslsqlparser;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.streamslience.simples.sqlparser.mpslsqlparser.dao.AddressDao;
import com.streamslience.simples.sqlparser.mpslsqlparser.dao.GoodsDao;
import com.streamslience.simples.sqlparser.mpslsqlparser.dao.UserDao;
import com.streamslience.simples.sqlparser.mpslsqlparser.entity.AddressInfoEntity;
import com.streamslience.simples.sqlparser.mpslsqlparser.entity.GoodsInfoEntity;
import com.streamslience.simples.sqlparser.mpslsqlparser.entity.UserInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MpslSqlParserApplicationTests {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {

    }

    @Test
    public void Insert() {
        for (int i = 0; i < 20; ++i) {
            addressDao.insert(new AddressInfoEntity(String.format("地址-%d", i)));
            goodsDao.insert(new GoodsInfoEntity(String.format("物料-%d", i)));
            userDao.insert(new UserInfoEntity(String.format("用户-%d", i)));
        }
    }

    /**
     * 先执行一遍Insert()进行数据插入
     */
    @Test
    public void Update() {
        //有条件
        Assert.assertEquals(true, new LambdaUpdateChainWrapper<>(addressDao).eq(AddressInfoEntity::getAddressName, "地址-1").update(new AddressInfoEntity("地址-1")));
        Assert.assertEquals(true, new LambdaUpdateChainWrapper<>(userDao).eq(UserInfoEntity::getUserName, "用户-1").update(new UserInfoEntity("用户-1")));
        Assert.assertEquals(true, new LambdaUpdateChainWrapper<>(goodsDao).eq(GoodsInfoEntity::getGoodsName, "物料-1").update(new GoodsInfoEntity("物料-1")));

        //无条件
        try {
            addressDao.update(new AddressInfoEntity("地址-1"), new LambdaQueryChainWrapper<>(addressDao).getWrapper());
            System.out.println("---------------------------------------地址恶意更新成功---------------------------------------");
        } catch (RuntimeException e) {
            System.err.println("---------------------------------------地址恶意更新失败---------------------------------------");//OutPut
        }

        try {
            goodsDao.update(new GoodsInfoEntity("物料-1"), new LambdaQueryChainWrapper<>(goodsDao).getWrapper());
            System.out.println("---------------------------------------物料恶意更新成功---------------------------------------");//OutPut
        } catch (RuntimeException r) {
            System.err.println("---------------------------------------物料恶意更新失败---------------------------------------");
        }

        try {
            userDao.update(new UserInfoEntity("用户-1"), new LambdaQueryChainWrapper<>(userDao).getWrapper());
            System.out.println("---------------------------------------用户恶意更新成功---------------------------------------");//OutPut
        } catch (RuntimeException r) {
            System.err.println("---------------------------------------用户恶意更新失败---------------------------------------");
        }


    }

    /**
     * 先清空数据库数据，在执行一遍Insert()插入数据
     */
    @Test
    public void Delete() {
        //有条件
        Assert.assertEquals(1, addressDao.delete(new LambdaQueryChainWrapper<>(addressDao).eq(AddressInfoEntity::getAddressName, "地址-1").getWrapper()));
        Assert.assertEquals(1, userDao.delete(new LambdaQueryChainWrapper<>(userDao).eq(UserInfoEntity::getUserName, "用户-1").getWrapper()));
        Assert.assertEquals(1, goodsDao.delete(new LambdaQueryChainWrapper<>(goodsDao).eq(GoodsInfoEntity::getGoodsName, "物料-1").getWrapper()));

        //无条件
        try {
            addressDao.delete(new LambdaQueryChainWrapper<>(addressDao).getWrapper());
            System.out.println("---------------------------------------地址恶意删除成功---------------------------------------");//OutPut
        } catch (RuntimeException r) {
            System.err.println("---------------------------------------地址恶意删除失败---------------------------------------");
        }

        try {
            userDao.delete(new LambdaQueryChainWrapper<>(userDao).getWrapper());
            System.out.println("---------------------------------------用户恶意删除成功---------------------------------------");
        } catch (RuntimeException r) {
            System.err.println("---------------------------------------用户恶意删除失败---------------------------------------");//OutPut
        }

        try {
            goodsDao.delete(new LambdaQueryChainWrapper<>(goodsDao).getWrapper());
            System.out.println("---------------------------------------物料恶意删除成功---------------------------------------");//OutPut
        } catch (RuntimeException r) {
            System.err.println("---------------------------------------物料恶意删除失败---------------------------------------");
        }
    }

}
