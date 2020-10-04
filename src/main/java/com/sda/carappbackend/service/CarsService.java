package com.sda.carappbackend.service;

import com.sda.carappbackend.domain.Car;
import com.sda.carappbackend.dto.CreateCarDto;
import com.sda.carappbackend.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {
    private final CarsRepository carsRepository;

    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public Car CreateCar(CreateCarDto car) {
        Car newCar = Car.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .color(car.getColor())
                .YearOfProduction(car.getYearOfProduction())
                .build();
        carsRepository.save(newCar);
        return newCar;

    }

    public List<Car> getListOfAllCars() {
        List<Car> allCars = carsRepository.findAll();
        return allCars;
    }

    public Car findCarById(Long id) {
        Car carById = carsRepository.findAllById(id);
        return carById;

    }

}
