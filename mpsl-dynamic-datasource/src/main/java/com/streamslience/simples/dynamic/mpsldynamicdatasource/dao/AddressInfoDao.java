package com.streamslience.simples.dynamic.mpsldynamicdatasource.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-12-09 11:06
 */
@Repository
public interface AddressInfoDao {

    @Insert("INSERT INTO xx_address_info(address_id,address) VALUES(#{param1},#{param2})")
    void Insert(@Param("id") String id, @Param("address") String address);

    @Update("UPDATE xx_address_info SET address = #{param2} WHERE address_id = #{param1}")
    int update(@Param("id") String id, @Param("address") String address);

}
