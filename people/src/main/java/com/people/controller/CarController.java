package com.people.controller;

import com.people.dto.CarDto;
import com.people.entity.Car;
import com.people.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.List;

@RequestMapping("/cars")
@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/")
    public ResponseEntity<CarDto> saveCar(@RequestBody CarDto carDto) {
        carService.saveCar(carDto);
        Logger.info("New car was created.");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<CarDto> getCarById(Long id){
        Logger.info("Car with id = " + id + " was returned.");
        return ResponseEntity.ok().body(carService.getCarById(id));
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll(){
        return new ResponseEntity<>(carService.getAll(), HttpStatus.OK);
    }
}
