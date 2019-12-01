package com.streamslience.simples.metainfo.mpslautofillmetainfo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h2>Title:</h2><br>
 * <h2>Description:</h2><br>
 *
 * @author StreamSlience
 * @Date 2019/11/30-20:35
 */
@Data
@TableName("xx_goods")
@NoArgsConstructor
public class GoodsEntity extends BaseEntity<GoodsEntity> {

    @TableId(type = IdType.UUID)
    private String goodsId;

    private String goodsName;

    public GoodsEntity(String goodsName) {
        this.goodsName = goodsName;
    }
}
