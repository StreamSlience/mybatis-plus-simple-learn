package com.streamslience.simples.sqlparser.mpslsqlparser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-12-09 19:36
 */
@Data
@Accessors(chain = true)
@TableName("goods_info")
public class GoodsInfoEntity {

    @TableId(type = IdType.UUID)
    private String goodsId;

    private String goodsName;

    public GoodsInfoEntity() {
    }

    public GoodsInfoEntity(String goodsName) {
        this.goodsName = goodsName;
    }
}
