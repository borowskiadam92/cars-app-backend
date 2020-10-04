package com.sda.carappbackend.service;

import com.sda.carappbackend.domain.Car;
import com.sda.carappbackend.dto.CreateCarDto;
import com.sda.carappbackend.repository.CarsRepository;
import com.sda.carappbackend.restTemplate.RestTemplateConfig;
import com.sda.carappbackend.view.CarView;
import com.sda.carappbackend.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsService {
    private final CarsRepository carsRepository;
    private static String USER_URL = "http://localhost:8080/users/external";
    private final RestTemplateConfig restTemplateConfig;

    @Autowired
    public CarsService(CarsRepository carsRepository, RestTemplateConfig restTemplateConfig) {
        this.carsRepository = carsRepository;
        this.restTemplateConfig = restTemplateConfig;
    }

    public Car CreateCar(CreateCarDto car) {
        Long userId = car.getUserId();
        UserView userView = gerUserFromExternalService(userId);
        Car newCar = Car.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .color(car.getColor())
                .yearOfProduction(car.getYearOfProduction())
                .userName(userView.getName())
                .userSurname(userView.getSurname())
                .userId(car.getUserId())
                .build();
        carsRepository.save(newCar);
        return newCar;

    }

    public List<Car> getListOfAllCars() {
        List<Car> allCars = carsRepository.findAll();
        return allCars;
    }

    public List<CarView> findForUser(Long id) {

        return carsRepository.findAllByUserId(id)
                .stream()
                .map(c -> new CarView(c.getBrand(), c.getModel(), c.getColor()))
                .collect(Collectors.toList());


    }

    private UserView gerUserFromExternalService(Long userId) {
        return restTemplateConfig.restTemplate().getForObject(USER_URL + userId, UserView.class);
    }

}
