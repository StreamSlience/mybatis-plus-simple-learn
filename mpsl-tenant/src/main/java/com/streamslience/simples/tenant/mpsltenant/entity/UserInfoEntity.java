package com.streamslience.simples.tenant.mpsltenant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-12-09 14:54
 */
@Data
@Accessors(chain = true)
@TableName("user_info")
public class UserInfoEntity {

    @TableId(type = IdType.UUID)
    private String userId;

    private String userName;

    private String tenantId;
}

