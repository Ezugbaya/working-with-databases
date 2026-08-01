package com.javarush.dao;

import com.javarush.domain.Country;
import org.hibernate.Session;

import java.util.List;

public class CountryDao {

    private final Session session;

    public CountryDao(Session session) {
        this.session = session;
    }

    public List<Country> findAll() {
        return session.createQuery("from Country", Country.class).list();
    }
}