package com.people.service.mapper;

import com.people.dto.CarDto;
import com.people.entity.Car;

public class CarMapper {

    public static CarDto carToCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .color(car.getColor())
                .brand(car.getBrand())
                .person(car.getPerson())
                .personId(car.getPerson().getId())
                .build();
    }

    public static Car carDtoToCar(CarDto carDto) {
        return Car.builder()
                .id(carDto.getId())
                .color(carDto.getColor())
                .brand(carDto.getBrand())
                .person(carDto.getPerson())
                .build();
    }
}
