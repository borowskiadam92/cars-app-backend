package com.sda.carappbackend.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {


    @Id
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String yearOfProduction;
    @NotNull
    private String color;

    private Long userId;

    private String userName;

    private String userSurname;

}
