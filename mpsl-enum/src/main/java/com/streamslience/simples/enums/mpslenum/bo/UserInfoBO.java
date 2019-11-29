package com.streamslience.simples.enums.mpslenum.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-11-28 21:55
 */
@Data
public class UserInfoBO {

    @ApiModelProperty("主键ID")
    private String userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("用户年龄")
    private Integer userAge;

    @ApiModelProperty("用户职务")
    private String userDuty;

    @ApiModelProperty("用户性别")
    private String userGender;

    @ApiModelProperty("用户国籍")
    private String userNationality;

}
