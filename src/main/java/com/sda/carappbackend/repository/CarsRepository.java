package com.sda.carappbackend.repository;


import com.sda.carappbackend.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {

    public Car findAllById(Long id);

}
