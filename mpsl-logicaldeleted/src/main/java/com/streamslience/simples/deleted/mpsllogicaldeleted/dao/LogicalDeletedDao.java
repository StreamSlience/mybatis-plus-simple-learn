package com.streamslience.simples.deleted.mpsllogicaldeleted.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.streamslience.simples.deleted.mpsllogicaldeleted.entity.LogicalDelete;
import org.springframework.stereotype.Repository;

/**
 * @author StreamSlience
 * @description 逻辑删除持久层接口
 * @creatdate 2019-11-29 12:26
 */
@Repository
public interface LogicalDeletedDao extends BaseMapper<LogicalDelete> {

    /**
     * <p>查询数据信息</p>
     *
     * @param id
     * @return
     */
    LogicalDelete getLogicalInfo(String id);

}
