package com.streamslience.simples.tenant.mpsltenant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.streamslience.simples.tenant.mpsltenant.entity.UserInfoEntity;
import org.springframework.stereotype.Repository;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-12-09 15:02
 */
@Repository
public interface UserDao extends BaseMapper<UserInfoEntity> {

}
