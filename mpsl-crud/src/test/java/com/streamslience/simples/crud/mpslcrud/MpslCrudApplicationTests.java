package com.streamslience.simples.crud.mpslcrud;

import com.streamslience.simples.crud.mpslcrud.dao.UserDao;
import com.streamslience.simples.crud.mpslcrud.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class MpslCrudApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void aInsert() {
        UserEntity user = new UserEntity();
        user.setUserName("我是一个用户");
        user.setUserAge(999);
        userDao.insert(user);
    }


}
