package com.streamslience.simples.deleted.mpsllogicaldeleted;

import com.streamslience.simples.deleted.mpsllogicaldeleted.dao.LogicalDeletedDao;
import com.streamslience.simples.deleted.mpsllogicaldeleted.entity.LogicalDelete;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@Slf4j
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class MpslLogicaldeleteApplicationTests {
    @Autowired
    private LogicalDeletedDao logicalDeletedDao;

    static String ID = "1200284902791925762";

    @Test
    void contextLoads() {
    }

    @Test
    public void logicalDeleted() {

    }


    /**
     * <p>新增逻辑删除数据</p>
     */
    @Test
    public void insert() {
        LogicalDelete logicalDelete = new LogicalDelete();
        logicalDelete.setCreateDate(new Date());
        int count = logicalDeletedDao.insert(logicalDelete);
    }

    /**
     * <p>查询数据</p>
     * ==>  Preparing: SELECT logical_id,update_date,deleted,create_date FROM xx_logical_delete WHERE logical_id=? <stronge>AND deleted='A' </stronge>
     * ==> Parameters: 1200284902791925762(String)
     */
    @Test
    public void select() {
        System.out.println(logicalDeletedDao.selectById(ID));
    }

    /**
     * <p>删除数据</p>
     * ==>  Preparing: UPDATE xx_logical_delete SET deleted='D' WHERE logical_id=?  <stronge>AND deleted='A' </stronge>
     * ==> Parameters: 1200284902791925762(String)
     */
    @Test
    public void delete() {
        int count = logicalDeletedDao.deleteById(ID);
    }


    /**
     * <p></p>
     * ==>  Preparing: SELECT * FROM xx_logical_delete WHERE logical_id = ?
     * ==> Parameters: 1200284902791925762(String)
     *
     * @notes: 只有使用MP自带的方法进行<stronge>删除</stronge>和<stronge>查找</stronge>时<br>
     * 才会附带逻辑删除功能,具体体现在SQL语句中自动拼接逻辑未删除条件
     */
    @Test
    public void getLogicalInfo() {
        System.out.println(logicalDeletedDao.getLogicalInfo(ID));
    }

}












