package com.people.service;

import com.people.dto.CarDto;
import com.people.entity.Car;
import com.people.repository.CarRepository;
import com.people.repository.PersonRepository;
import com.people.service.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;
    private PersonRepository personRepository;


    @Autowired
    public CarService(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
    }

    public void saveCar(CarDto carDto) {
        carDto.setPerson(personRepository.getById(carDto.getPersonId()));
        carRepository.save(CarMapper.carDtoToCar(carDto));
    }

    public CarDto getCarById(Long id) {
        return CarMapper.carToCarDto(carRepository.getById(id));
    }

    public List<CarDto> getAll(){
        List<Car> carList = carRepository.findAll();

        List<CarDto> carDtoList = new ArrayList<>();

        for(Car car: carList){
            carDtoList.add(CarMapper.carToCarDto(car));
        }
        return carDtoList;
    }
}
