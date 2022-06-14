package com.example.mybatis;

import com.example.mybatis.dto.CarDto;
import com.example.mybatis.mapper.CarMapper;
import com.example.mybatis.po.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapStructExample {

	@Test
	void context(){
		Car car = new Car();
		car.setMake("范德彪");
		car.setNumberOfSeats("赵本山");

		CarDto carDto = CarMapper.CAR_MAPPER.carToCarDto(car);
		Assertions.assertEquals(car.getMake(),carDto.getMake());
		Assertions.assertEquals(car.getNumberOfSeats(),carDto.getNumberOfSeats());

	}

}
