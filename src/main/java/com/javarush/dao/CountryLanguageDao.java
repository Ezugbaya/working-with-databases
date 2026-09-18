package com.javarush.dao;

import com.javarush.domain.CountryLanguage;
import com.javarush.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CountryLanguageDao {

    public List<CountryLanguage> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from CountryLanguage", CountryLanguage.class).list();
        }
    }
}