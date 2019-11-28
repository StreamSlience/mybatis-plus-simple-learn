package com.streamslience.simples.enums.mpslenum.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.streamslience.simples.enums.mpslenum.enums.DutyEnum;
import com.streamslience.simples.enums.mpslenum.enums.GenderEnum;
import com.streamslience.simples.enums.mpslenum.enums.NationalityEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-11-28 12:50
 */
@Data
@TableName("xx_user_info")
public class UserInfoEntity {

    @ApiModelProperty("主键ID")
    @TableId
    private String userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("用户年龄")
    private Integer userAge;

    @ApiModelProperty("用户职务")
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private DutyEnum userDuty;

    @ApiModelProperty("用户性别")
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private GenderEnum userGender;

    @ApiModelProperty("用户国籍")
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private NationalityEnum userNationality;

    @ApiModelProperty("邮箱")
    private String userEmail;

    @ApiModelProperty("上级主键ID")
    private String managerId;

    @ApiModelProperty("创建人主键ID")
    private String createUserId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "YYYY-mm-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("修改人主键ID")
    private String modifiedUserId;

    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = "YYYY-mm-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifiedTime;

    @ApiModelProperty("逻辑删除标识")
    @TableLogic
    private String deleted = "A";
}
