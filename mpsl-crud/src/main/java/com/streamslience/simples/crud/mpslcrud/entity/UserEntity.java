package com.streamslience.simples.crud.mpslcrud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author StreamSlience
 * @description 用户实体类
 * @creatdate 2019-12-01 22:16
 */
@Data
@TableName("xx_user")
public class UserEntity {
    @TableId(type = IdType.UUID)
    private String userId;

    private String userName;

    private Integer userAge;
}
