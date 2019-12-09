package com.streamslience.simples.dynamic.mpsldynamicdatasource.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-12-09 10:34
 */
@Repository
public interface GoodsDao {

    @Insert("INSERT INTO xx_goods(goods_id,goods_name) VALUES(#{id},#{name})")
    void insert(@Param("id") String goodsId, @Param("name") String goodsName);

    @Delete("DELETE FROM xx_goods WHERE goods_name = #{param1}")
    int delete(@Param("name") String goodsName);

}
