package com.streamslience.simples.deleted.mpsllogicaldeleted;


import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.streamslience.simples.deleted.mpsllogicaldeleted.dao.LogicalDeletedDao;
import com.streamslience.simples.deleted.mpsllogicaldeleted.entity.LogicalDelete;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class LogicalDeletedTest {

    static final String PATTERN_1 = "{}----------------------------------------------------->";

    @Autowired
    private LogicalDeletedDao logicalDeletedDao;

    @Test
    @Order(1)
    public void add() {
        for (int i = 0; i < 20; ++i) {
            LogicalDelete logicalDelete = new LogicalDelete();
            logicalDelete.setLogicalId(i);
            logicalDelete.setCreateDate(new Date());
            logicalDeletedDao.insert(logicalDelete);
        }
    }

    @Test
    @Order(2)
    public void select() {
        Console.error(PATTERN_1, "selectBatchIds");
        logicalDeletedDao.selectBatchIds(Arrays.asList("1", "2"));

        Console.error(PATTERN_1, "selectById");
        logicalDeletedDao.selectById(3);

        Console.error(PATTERN_1, "selectByMap");
        Map<String, Object> map = new HashMap<>();
        map.put("logical_id", 4);
        logicalDeletedDao.selectByMap(map);

        Console.error(PATTERN_1, "selectCount");
        logicalDeletedDao.selectCount(new LambdaQueryChainWrapper<>(logicalDeletedDao).ge(LogicalDelete::getLogicalId, 5).getWrapper());

        Console.error(PATTERN_1, "selectList");
        logicalDeletedDao.selectList(new LambdaQueryChainWrapper<>(logicalDeletedDao).between(LogicalDelete::getLogicalId, 2, 5).getWrapper()).forEach(System.out::println);

        Console.error(PATTERN_1, "selectMaps");
        logicalDeletedDao.selectMaps(new LambdaQueryChainWrapper<>(logicalDeletedDao).eq(LogicalDelete::getLogicalId, 12).getWrapper()).forEach(System.out::println);

        Console.error(PATTERN_1, "selectMapsPage");
        IPage<Map<String, Object>> pageResult1 = logicalDeletedDao.selectMapsPage(new Page<>(1, 2), new LambdaQueryChainWrapper<>(logicalDeletedDao).getWrapper());
        Assert.assertEquals(20, pageResult1.getTotal());

        Console.error(PATTERN_1, "selectObjs");
        logicalDeletedDao.selectObjs(new LambdaQueryChainWrapper<>(logicalDeletedDao).lt(LogicalDelete::getLogicalId, 5).orderByDesc(LogicalDelete::getCreateDate).getWrapper()).forEach(Console::print);

        Console.error(PATTERN_1, "selectOne");
        logicalDeletedDao.selectOne(new LambdaQueryChainWrapper<>(logicalDeletedDao).eq(LogicalDelete::getLogicalId, 10).getWrapper());

        Console.error(PATTERN_1, "selectPage");
        IPage<LogicalDelete> pageResult2 = logicalDeletedDao.selectPage(new Page<>(1, 2), new LambdaQueryChainWrapper<>(logicalDeletedDao).getWrapper());
        Assert.assertEquals(20, pageResult2.getTotal());
    }

    @Test
    @Order(3)
    public void update() {
        log.info(PATTERN_1, "update");
        LogicalDelete logicalDelete = new LogicalDelete();
        logicalDelete.setUpdateDate(new Date());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("logical_id", 1);
        logicalDeletedDao.update(logicalDelete, wrapper);

        log.info(PATTERN_1, "updateById");
        logicalDelete.setLogicalId(2);
        logicalDeletedDao.updateById(logicalDelete);
    }

    @Test
    @Order(4)
    public void delete() {

        Console.error(PATTERN_1, "delete");
        logicalDeletedDao.delete(new LambdaQueryChainWrapper<>(logicalDeletedDao).eq(LogicalDelete::getLogicalId, 0).getWrapper());

        Console.error(PATTERN_1, "deleteById");
        logicalDeletedDao.deleteById(1);

        Console.error(PATTERN_1, "deleteByMap");
        Map<String, Object> map = new HashMap<>();
        map.put("logical_id", 2);
        logicalDeletedDao.deleteByMap(map);

        Console.error(PATTERN_1, "deleteBatchIds");
        logicalDeletedDao.deleteBatchIds(new ArrayList<Integer>() {{
            for (int i = 3; i < 20; ++i)
                add(i);
        }});
    }

}
