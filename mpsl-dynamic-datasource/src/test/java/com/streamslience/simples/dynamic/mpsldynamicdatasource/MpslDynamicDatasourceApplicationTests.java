package com.streamslience.simples.dynamic.mpsldynamicdatasource;

import com.streamslience.simples.dynamic.mpsldynamicdatasource.service.AddressInfoService;
import com.streamslience.simples.dynamic.mpsldynamicdatasource.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class MpslDynamicDatasourceApplicationTests {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AddressInfoService addressInfoService;

    @Test
    void contextLoads() {
    }

    @Test
    public void insert_1() {
        goodsService.insert("哈哈哈哈哈");
    }

    @Test
    public void delete_1() {
        int count = goodsService.delete("哈哈哈哈哈");
        System.out.println(count);
    }

    @Test
    public void insert_2() {
        addressInfoService.Insert("我是一个新增地址");
    }

    @Test
    public void update_2() {
        int count = addressInfoService.update("9080b4b071854f92a5f64329a23ec388", "我是一个修改地址");
        System.out.println(count);
    }

}
