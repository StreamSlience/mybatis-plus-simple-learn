package com.streamslience.simples.enums.mpslenum.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 申明通用枚举方式二:实现IEnum接口
 *
 * @author StreamSlience
 * @description 职务枚举
 * @creatdate 2019-11-27 19:01
 */
@Getter
@AllArgsConstructor
public enum DutyEnum implements IEnum<String> {

    DIRVER("dirver", "司机"),
    TEACHER("teacher", "教师");

    private String code;
    private String value;

    @Override
    public String toString() {
        return value;
    }
}
