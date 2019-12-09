package com.streamslience.simples.sqlparser.mpslsqlparser.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.streamslience.simples.sqlparser.mpslsqlparser.entity.UserInfoEntity;
import org.springframework.stereotype.Repository;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-12-09 19:49
 */
@Repository
public interface UserDao extends BaseMapper<UserInfoEntity> {

}
