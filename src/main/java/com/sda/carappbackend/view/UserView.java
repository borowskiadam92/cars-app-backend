package com.sda.carappbackend.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserView {

    private String name;

    private String surname;

    private String address;

    private Integer age;
}
