package com.streamslience.simples.optimisticlocker.mpsloptimisticlocker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author StreamSlience
 * @description 物料实体类
 * @creatdate 2019-12-06 17:02
 */
@Data
@TableName("xx_goods")
public class GoodsEntity {

    @TableId(type = IdType.UUID)
    private String goodsId;

    private String goodsName;

    @Version
    private Integer version = 0;
}
