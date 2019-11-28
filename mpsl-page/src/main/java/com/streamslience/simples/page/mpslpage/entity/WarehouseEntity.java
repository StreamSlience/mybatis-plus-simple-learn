package com.streamslience.simples.page.mpslpage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <h2>Title:</h2><br>
 * <h2>Description:</h2><br>
 *
 * @author StreamSlience
 * @Date 2019/11/29-0:27
 */
@Data
@Accessors(chain = true, prefix = "{warehouse,goods}")
@TableName("xx_warehouse")
public class WarehouseEntity extends BaseEntity {

    @ApiModelProperty("仓库主键")
    private String warehouseId;

    @ApiModelProperty("仓库名称")
    private String warehouseName;

    @ApiModelProperty("仓库容积")
    private Integer warehouseCapacity;

}
