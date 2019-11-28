package com.streamslience.simples.enums.mpslenum.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 申明通用枚举方式一:使用@EnumValue注解枚举属性
 *
 * @author StreamSlience
 * @description 性别枚举
 * @creatdate 2019-11-27 18:57
 */
@Getter
@AllArgsConstructor
public enum GenderEnum {

    M("M", "男性"),
    F("F", "女性");

    @EnumValue
    private final String code;
    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
