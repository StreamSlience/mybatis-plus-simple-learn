package com.streamslience.simples.crud.mpslcrud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.streamslience.simples.crud.mpslcrud.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author StreamSlience
 * @description 用户持久成层接口
 * @creatdate 2019-12-01 22:20
 */
@Repository
public interface UserDao extends BaseMapper<UserEntity> {

}
