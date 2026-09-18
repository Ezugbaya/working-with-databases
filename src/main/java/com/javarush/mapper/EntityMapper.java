package com.javarush.mapper;

import com.javarush.domain.City;
import com.javarush.domain.Country;
import com.javarush.domain.CountryLanguage;
import com.javarush.dto.CityDto;
import com.javarush.dto.CountryDto;
import com.javarush.dto.CountryLanguageDto;

import java.util.List;
import java.util.stream.Collectors;

public class EntityMapper {

    public CountryDto toDto(Country country) {

        CountryDto dto = new CountryDto();

        dto.setId(country.getId());
        dto.setCode(country.getCode());
        dto.setCode2(country.getCode2());
        dto.setName(country.getName());
        dto.setContinent(String.valueOf(country.getContinent()));
        dto.setRegion(country.getRegion());
        dto.setSurfaceArea(country.getSurfaceArea());
        dto.setIndepYear(country.getIndepYear());
        dto.setPopulation(country.getPopulation());
        dto.setLifeExpectancy(country.getLifeExpectancy());
        dto.setGnp(country.getGnp());
        dto.setGnpoId(country.getGnpoId());
        dto.setLocalName(country.getLocalName());
        dto.setGovernmentForm(country.getGovernmentForm());
        dto.setHeadOfState(country.getHeadOfState());
        dto.setCapital(country.getCapital());

        dto.setCities(
                country.getCities()
                        .stream()
                        .map(this::toDto)
                        .collect(Collectors.toList())
        );

        dto.setLanguages(
                country.getLanguages()
                        .stream()
                        .map(this::toDto)
                        .collect(Collectors.toList())
        );

        return dto;
    }

    public CityDto toDto(City city) {

        CityDto dto = new CityDto();

        dto.setId(city.getId());
        dto.setName(city.getName());
        dto.setDistrict(city.getDistrict());
        dto.setPopulation(city.getPopulation());

        return dto;
    }

    public CountryLanguageDto toDto(CountryLanguage language) {

        CountryLanguageDto dto = new CountryLanguageDto();

        dto.setId(language.getId());
        dto.setLanguage(language.getLanguage());
        dto.setOfficial(language.getOfficial());
        dto.setPercentage(language.getPercentage());

        return dto;
    }

    public List<CountryDto> toDto(List<Country> countries) {
        return countries.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}