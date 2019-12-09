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
 * @creatdate 2019-12-09 19:30
 */
@Data
@Accessors(chain = true)
@TableName("user_info")
public class UserInfoEntity {

    @TableId(type = IdType.UUID)
    private String user_id;

    private String userName;

    public UserInfoEntity() {
    }

    public UserInfoEntity(String userName) {
        this.userName = userName;
    }
}

