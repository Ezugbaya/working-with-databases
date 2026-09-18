package com.javarush.dto;

import lombok.Data;

@Data
public class CityDto {

    private Integer id;
    private String name;
    private String district;
    private Integer population;
}