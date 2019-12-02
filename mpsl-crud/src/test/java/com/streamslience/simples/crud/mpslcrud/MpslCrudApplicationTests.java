package com.streamslience.simples.crud.mpslcrud;

import com.streamslience.simples.crud.mpslcrud.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class MpslCrudApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void aInsert() {

    }

}
