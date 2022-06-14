package com.example.mybatis.mapper;

import com.example.mybatis.dto.CarDto;
import com.example.mybatis.po.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

	CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);

	CarDto carToCarDto(Car car);

}
