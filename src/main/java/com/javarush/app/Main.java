package com.javarush.app;

import com.javarush.dao.CountryDao;
import com.javarush.domain.Country;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CountryDao countryDao = new CountryDao();

        List<Country> countries = countryDao.findAll();

        System.out.println("Количество стран: " + countries.size());

        for (int i = 0; i < 10 && i < countries.size(); i++) {

            Country country = countries.get(i);

            System.out.println(
                    country.getId() + " | " +
                            country.getName()
            );
        }
    }
}