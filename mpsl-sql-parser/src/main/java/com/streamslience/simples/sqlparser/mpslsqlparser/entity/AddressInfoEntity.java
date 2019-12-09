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
 * @creatdate 2019-12-09 19:37
 */
@Data
@Accessors(chain = true)
@TableName("address_info")
public class AddressInfoEntity {

    @TableId(type = IdType.UUID)
    private String addressId;

    private String addressName;

    public AddressInfoEntity() {
    }

    public AddressInfoEntity(String addressName) {
        this.addressName = addressName;
    }

}
