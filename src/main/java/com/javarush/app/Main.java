package com.javarush.app;

import com.javarush.dao.CityDao;
import com.javarush.dao.CountryDao;
import com.javarush.dao.CountryLanguageDao;

public class Main {

    public static void main(String[] args) {

        CountryDao countryDao = new CountryDao();
        CityDao cityDao = new CityDao();
        CountryLanguageDao languageDao = new CountryLanguageDao();

        System.out.println("Стран: " + countryDao.findAll().size());
        System.out.println("Городов: " + cityDao.findAll().size());
        System.out.println("Языков: " + languageDao.findAll().size());
    }
}