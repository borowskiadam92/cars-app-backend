package com.sda.carappbackend.repository;


import com.sda.carappbackend.domain.Car;
import com.sda.carappbackend.view.CarView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByUserId(Long id);


}
