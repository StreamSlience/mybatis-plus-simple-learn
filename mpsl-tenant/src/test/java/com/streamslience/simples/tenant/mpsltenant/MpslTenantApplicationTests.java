package com.streamslience.simples.tenant.mpsltenant;

import com.streamslience.simples.tenant.mpsltenant.dao.TenantDao;
import com.streamslience.simples.tenant.mpsltenant.dao.UserDao;
import com.streamslience.simples.tenant.mpsltenant.entity.TenantInfoEntity;
import com.streamslience.simples.tenant.mpsltenant.entity.UserInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MpslTenantApplicationTests {

    @Autowired
    private ApiContext apiContext;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TenantDao tenantDao;

    @Test
    public void contextLoads() {
    }

    @Before
    public void before() {
        System.out.println(
                apiContext.setCurrentTenantId(
                        UUID.randomUUID().toString().replaceAll("-", "")));
    }

    @Test
    public void insert_1() {
        UserInfoEntity user = new UserInfoEntity();
        user.setUserName("呵呵");
        Assert.assertTrue(userDao.insert(user) > 0);

        user = userDao.selectById(user.getUserId());
        log.info("insert user = {}", user);

        Assert.assertEquals(apiContext.getCurrentTenant(), user.getTenantId());
    }

    @Test
    public void insert_2() {
        TenantInfoEntity tenant = new TenantInfoEntity();
        tenant.setTenantId(apiContext.getCurrentTenant());
        tenant.setTenantName("我是一个租户");
        Assert.assertTrue(tenantDao.insert(tenant) > 0);
    }
}
