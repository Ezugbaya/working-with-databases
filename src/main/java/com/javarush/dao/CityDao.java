package com.javarush.dao;

import com.javarush.domain.City;
import org.hibernate.Session;

import java.util.List;

public class CityDao {

    private final Session session;

    public CityDao(Session session) {
        this.session = session;
    }

    public List<City> findAll() {
        return session.createQuery(
                "select distinct city " +
                        "from City city " +
                        "join fetch city.country country " +
                        "join fetch country.languages",
                City.class
        ).list();
    }

    public City getById(int id) {
        return session.createQuery(
                        "select city " +
                                "from City city " +
                                "join fetch city.country country " +
                                "join fetch country.languages " +
                                "where city.id = :id",
                        City.class
                )
                .setParameter("id", id)
                .uniqueResult();
    }
    public List<City> getByIds(List<Integer> ids) {

        return session.createQuery(
                        "select distinct city " +
                                "from City city " +
                                "join fetch city.country country " +
                                "join fetch country.languages " +
                                "where city.id in (:ids)",
                        City.class
                )
                .setParameterList("ids", ids)
                .list();
    }

    public int getTotalCount() {
        return session.createQuery(
                "select count(city.id) from City city",
                Long.class
        ).uniqueResult().intValue();
    }
}