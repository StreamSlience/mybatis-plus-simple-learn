package com.streamslience.simples.metainfo.mpslautofillmetainfo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <h2>Title:公用字段类</h2><br>
 * <h2>Description:</h2><br>
 * 抽离数据库表的公用字段。
 *
 * @author StreamSlience
 * @Date 2019/11/30-20:35
 */
@Getter
@Setter
public abstract class BaseEntity<T extends Model> extends Model {

    private String createId;

    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    private String updateId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;

    @TableLogic(value = "A", delval = "D")
    private String deleted = "A";
}
