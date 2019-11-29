package com.streamslience.simples.deleted.mpsllogicaldeleted.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author StreamSlience
 * @description 基础实体类
 * @creatdate 2019-11-29 12:20
 */
@Data
@Accessors(chain = true)
public class Base {

    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    //@TableLogic(value = "A", delval = "D")//可以进行局部设置覆盖全局设置
    @TableLogic
    @ApiModelProperty("逻辑删除")
    private String deleted = "A";
}
