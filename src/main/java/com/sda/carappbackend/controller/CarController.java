package com.sda.carappbackend.controller;

import com.sda.carappbackend.domain.Car;
import com.sda.carappbackend.dto.CreateCarDto;
import com.sda.carappbackend.service.CarsService;
import com.sda.carappbackend.view.CarView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    private CarsService serviceCars;

    @Autowired
    public CarController(CarsService serviceCars) {
        this.serviceCars = serviceCars;
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody @Valid CreateCarDto newCar) {
        Car car = serviceCars.CreateCar(newCar);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getListOfAllCars() {
        List<Car> listOfAllCars = serviceCars.getListOfAllCars();
        return new ResponseEntity<>(listOfAllCars, HttpStatus.OK);
    }

    @GetMapping("/external/{userId}")
    public List<CarView> getCars(@PathVariable Long userId) {
        return serviceCars.findForUser(userId);

    }


}
