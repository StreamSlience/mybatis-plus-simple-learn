package com.streamslience.simples.deleted.mpsllogicaldeleted;

import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.streamslience.simples.deleted.mpsllogicaldeleted.dao.LogicalDeletedDao;
import com.streamslience.simples.deleted.mpsllogicaldeleted.entity.LogicalDelete;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.x509.IPAddressName;

import java.sql.Wrapper;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Title:</h2><br>
 * <h2>Description:</h2><br>
 *
 * @author StreamSlience
 * @Date 2019/11/29-23:16
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class LogicalDeletedTest {

    static final String PATTERN = "{}----------------------------------------------------->";

    @Autowired
    private LogicalDeletedDao logicalDeletedDao;

    @Test
    @Order(1)
    public void deleteAll() {
        for (int i = 0; i < 20; ++i) {
            LogicalDelete logicalDelete = new LogicalDelete();
            logicalDelete.setLogicalId(i);
            logicalDelete.setCreateDate(new Date());
            logicalDeletedDao.insert(logicalDelete);
        }
        Console.error(PATTERN, "selectBatchIds");
        logicalDeletedDao.selectBatchIds(Arrays.asList("1", "2"));

        Console.error(PATTERN, "selectById");
        logicalDeletedDao.selectById(3);

        Console.error(PATTERN, "selectByMap");
        Map<String, Object> map = new HashMap<>();
        map.put("logical_id", 4);
        logicalDeletedDao.selectByMap(map);

        //TODO:这里不能使用链式条件构造器
        Console.error(PATTERN, "selectCount");
        logicalDeletedDao.selectCount(new LambdaQueryChainWrapper<>(logicalDeletedDao).ge(LogicalDelete::getLogicalId, 5));

        Console.error(PATTERN, "selectList");
        logicalDeletedDao.selectList(new LambdaQueryChainWrapper<>(logicalDeletedDao).between(LogicalDelete::getLogicalId, 2, 5)).forEach(System.out::println);

        Console.error(PATTERN, "selectMaps");
        logicalDeletedDao.selectMaps(new LambdaQueryChainWrapper<>(logicalDeletedDao).eq(LogicalDelete::getLogicalId, 12)).forEach(System.out::println);

        Console.error(PATTERN, "selectMapsPage");
        IPage<Map<String, Object>> pageResult1 = logicalDeletedDao.selectMapsPage(new Page<>(1, 2), new LambdaQueryChainWrapper<>(logicalDeletedDao));
        Assert.assertEquals(20, pageResult1.getTotal());
        Assert.assertEquals(2, pageResult1.getSize());
        Assert.assertEquals(1, pageResult1.getPages());

        Console.error(PATTERN, "selectObjs");
        logicalDeletedDao.selectObjs(new LambdaQueryChainWrapper<>(logicalDeletedDao).lt(LogicalDelete::getLogicalId, 5).orderByDesc(LogicalDelete::getCreateDate)).forEach(Console::print);

        Console.error(PATTERN, "selectOne");
        logicalDeletedDao.selectOne(new LambdaQueryChainWrapper<>(logicalDeletedDao));

        Console.error(PATTERN, "selectPage");
        IPage<LogicalDelete> pageResult2 = logicalDeletedDao.selectPage(new Page<>(1, 2), new LambdaQueryChainWrapper<>(logicalDeletedDao));
        Assert.assertEquals(20, pageResult2.getTotal());
        Assert.assertEquals(2, pageResult2.getSize());
        Assert.assertEquals(1, pageResult2.getPages());
    }

}
