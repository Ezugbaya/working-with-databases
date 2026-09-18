package com.javarush.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CountryDto {

    private Integer id;
    private String code;
    private String code2;
    private String name;
    private String continent;
    private String region;
    private BigDecimal surfaceArea;
    private Short indepYear;
    private Integer population;
    private BigDecimal lifeExpectancy;
    private BigDecimal gnp;
    private BigDecimal gnpoId;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private Integer capital;

    private List<CityDto> cities;
    private List<CountryLanguageDto> languages;
}