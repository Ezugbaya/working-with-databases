package com.javarush.service;

import com.javarush.domain.City;
import com.javarush.domain.Country;
import com.javarush.domain.CountryLanguage;
import com.javarush.redis.CityCountry;
import com.javarush.redis.Language;

import java.util.Set;
import java.util.stream.Collectors;

public class CityCountryService {

    public CityCountry mapCity(City city) {

        CityCountry result = new CityCountry();

        result.setId(city.getId());
        result.setName(city.getName());
        result.setDistrict(city.getDistrict());
        result.setPopulation(city.getPopulation());

        Country country = city.getCountry();

        result.setCountryCode(country.getCode());
        result.setAlternativeCountryCode(country.getCode2());
        result.setCountryName(country.getName());
        result.setContinent(country.getContinent());
        result.setCountryRegion(country.getRegion());
        result.setCountrySurfaceArea(country.getSurfaceArea());
        result.setCountryPopulation(country.getPopulation());

        Set<Language> languages = country.getLanguages()
                .stream()
                .map(this::mapLanguage)
                .collect(Collectors.toSet());

        result.setLanguages(languages);

        return result;
    }

    private Language mapLanguage(CountryLanguage countryLanguage) {

        Language result = new Language();

        result.setLanguage(countryLanguage.getLanguage());
        result.setOfficial(countryLanguage.getOfficial());
        result.setPercentage(countryLanguage.getPercentage());

        return result;
    }
}