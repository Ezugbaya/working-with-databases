package com.javarush.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CountryLanguageDto {

    private Integer id;
    private String language;
    private Boolean official;
    private BigDecimal percentage;
}