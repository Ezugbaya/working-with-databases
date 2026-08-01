package com.javarush.app;

import com.javarush.dao.CountryDao;
import com.javarush.domain.Country;
import com.javarush.dto.CountryDto;
import com.javarush.mapper.EntityMapper;
import com.javarush.redis.RedisClientHolder;
import com.javarush.service.RedisService;
import com.javarush.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<CountryDto> countries;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CountryDao dao = new CountryDao(session);

            List<Country> countryList = dao.findAll();

            EntityMapper mapper = new EntityMapper();

            countries = mapper.toDto(countryList);
        }

        RedisService redisService = new RedisService();

        redisService.saveCountries(countries);

        System.out.println("В Redis сохранено стран: " + countries.size());

        RedisClientHolder.shutdown();
    }
}