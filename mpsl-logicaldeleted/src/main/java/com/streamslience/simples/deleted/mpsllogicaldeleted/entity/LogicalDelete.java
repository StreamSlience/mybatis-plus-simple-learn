package com.streamslience.simples.deleted.mpsllogicaldeleted.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author StreamSlience
 * @description 逻辑删除实体
 * @creatdate 2019-11-29 12:17
 */
@Data
@ToString(callSuper = true)
public class LogicalDelete extends Base {

    @TableId
    @ApiModelProperty("逻辑删除主键")
    private String logicalId;

}
