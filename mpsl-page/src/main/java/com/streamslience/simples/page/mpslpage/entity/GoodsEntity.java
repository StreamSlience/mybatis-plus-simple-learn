package com.streamslience.simples.page.mpslpage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <h2>Title:</h2><br>
 * <h2>Description:</h2><br>
 *
 * @author StreamSlience
 * @Date 2019/11/29-0:03
 */
@Data
@Accessors(chain = true, prefix = "goods")
@TableName("xx_goods")
public class GoodsEntity extends BaseEntity {

    @ApiModelProperty("物料主键")
    @TableId
    private String goodsId;

    @ApiModelProperty("物料名称")
    private String goodsName;

    @ApiModelProperty("物料产地")
    private String goodsPlaceOfOrigin;

    @ApiModelProperty("仓库主键")
    private String warehouseId;

}
