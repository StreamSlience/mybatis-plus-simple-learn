package com.streamslience.simples.enums.mpslenum.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.streamslience.simples.enums.mpslenum.entity.UserInfoEntity;
import org.springframework.stereotype.Repository;


/**
 * @author SteamSlience
 * @description 学生表持久层接口
 * @creatdate 2019-10-19 21:39
 */
@Repository
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {

}
