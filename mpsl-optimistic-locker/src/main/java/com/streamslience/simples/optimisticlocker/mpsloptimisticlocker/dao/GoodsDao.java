package com.streamslience.simples.optimisticlocker.mpsloptimisticlocker.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.streamslience.simples.optimisticlocker.mpsloptimisticlocker.entity.GoodsEntity;
import org.springframework.stereotype.Repository;

/**
 * @author StreamSlience
 * @description 物料持久层
 * @creatdate 2019-12-06 17:18
 */
@Repository
public interface GoodsDao extends BaseMapper<GoodsEntity> {


}
