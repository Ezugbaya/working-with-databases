package com.javarush.dao;

import com.javarush.domain.Country;
import com.javarush.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CountryDao {

    public List<Country> findAll() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery("from Country", Country.class)
                    .getResultList();
        }
    }
}