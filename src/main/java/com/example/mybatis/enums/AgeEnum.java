package com.example.mybatis.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;

@Getter
public enum AgeEnum implements IEnum<Integer> {
	ONE(1, "一岁"),
	TWO(2, "二岁"),
	THREE(3, "三岁");

	@JsonValue
	private final int value;
	private final String desc;

	AgeEnum(final int value, final String desc) {
		this.value = value;
		this.desc = desc;
	}


	@Override
	public String toString() {
		return desc;
	}



	@Override
	public Integer getValue() {
		return value;
	}
}
