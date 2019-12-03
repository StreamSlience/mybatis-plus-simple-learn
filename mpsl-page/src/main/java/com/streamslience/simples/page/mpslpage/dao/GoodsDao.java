package com.streamslience.simples.page.mpslpage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.streamslience.simples.page.mpslpage.entity.GoodsEntity;
import org.springframework.stereotype.Repository;

/**
 * @author StreamSlience
 * @description 物料持久层接口
 * @creatdate 2019-12-03 11:31
 */
@Repository
public interface GoodsDao extends BaseMapper<GoodsEntity> {

    /**
     * <p>获取所有物料信息</p>
     *
     * @return
     */
    IPage<GoodsEntity> getGoods(IPage page);

}
