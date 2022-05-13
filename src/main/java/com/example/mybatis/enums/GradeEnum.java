package com.example.mybatis.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author kylin
 */
@Getter
@ToString
public enum GradeEnum {

    PRIMARY(1, "小学"),  SECONDORY(2, "中学"),  HIGH(3, "高中");

    GradeEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    //@EnumValue
    private final int code;

    //@EnumValue
    private final String descp;


}
