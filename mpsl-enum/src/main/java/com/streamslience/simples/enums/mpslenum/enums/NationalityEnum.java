package com.streamslience.simples.enums.mpslenum.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author StreamSlience
 * @description 用户国籍枚举
 * @creatdate 2019-11-28 12:50
 */
@Getter
@AllArgsConstructor
public enum NationalityEnum {

    CHINA(0, "中国"),
    MONGOLIA(1, "蒙古"),
    JAPAN(2, "日本");

    @EnumValue
    private final int code;
    private final String value;

}
