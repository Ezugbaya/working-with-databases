package com.javarush.app;

import com.javarush.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        HibernateUtil.getSessionFactory();

        System.out.println("Hibernate успешно подключился!");

    }
}