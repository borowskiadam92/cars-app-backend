package com.sda.carappbackend.dto;

import com.sun.istack.NotNull;
import lombok.Data;


@Data
public class CreateCarDto {

    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String YearOfProduction;
    @NotNull
    private String color;

}
