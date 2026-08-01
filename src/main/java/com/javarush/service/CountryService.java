package com.javarush.service;

import com.javarush.dao.CountryDao;
import com.javarush.domain.Country;
import com.javarush.util.HibernateUtil;
import org.hibernate.Session;

public class CountryService {

    public void test() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CountryDao dao = new CountryDao(session);

            Country country = dao.findAll().get(0);

            System.out.println(country.getName());
            System.out.println("Городов: " + country.getCities().size());
            System.out.println("Языков: " + country.getLanguages().size());
        }
    }
}