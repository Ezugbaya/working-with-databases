package com.javarush.dao;

import com.javarush.domain.City;
import com.javarush.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CityDao {

    public List<City> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from City", City.class).list();
        }
    }
}