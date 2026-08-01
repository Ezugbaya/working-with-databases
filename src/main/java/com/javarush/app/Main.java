package com.javarush.app;

import com.javarush.dao.CityDao;
import com.javarush.domain.City;
import com.javarush.redis.CityCountry;
import com.javarush.redis.RedisClientHolder;
import com.javarush.service.CityCountryService;
import com.javarush.service.RedisService;
import com.javarush.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<City> cities;

        // Получаем все города из MySQL
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CityDao cityDao = new CityDao(session);
            cities = cityDao.findAll();
        }

        System.out.println("Из MySQL считано городов: " + cities.size());

        // Подготавливаем данные для Redis
        CityCountryService mapper = new CityCountryService();
        List<CityCountry> preparedData = mapper.mapCities(cities);

        // Сохраняем в Redis
        RedisService redisService = new RedisService();
        redisService.save(preparedData);

        System.out.println("В Redis сохранено городов: " + preparedData.size());

        // Те же id, что используются в примере JavaRush
        List<Integer> ids = List.of(
                3, 2545, 123, 4, 189,
                89, 3458, 1189, 10, 102
        );

        // ---------------- Redis ----------------

        long startRedis = System.nanoTime();
        redisService.getRaw(ids);
        long redisTime = (System.nanoTime() - startRedis) / 1_000_000;

        // ---------------- MySQL ----------------

        long startMysql = System.nanoTime();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CityDao cityDao = new CityDao(session);
            cityDao.getByIds(ids);
        }

        long mysqlTime = (System.nanoTime() - startMysql) / 1_000_000;

        // ---------------- Результат ----------------

        System.out.println("-------------------------------------");
        System.out.println("Redis : " + redisTime + " ms");
        System.out.println("MySQL : " + mysqlTime + " ms");
        System.out.println("-------------------------------------");

        RedisClientHolder.shutdown();
        HibernateUtil.getSessionFactory().close();
    }
}
