package com.reto2.grupo3.util;

import jakarta.persistence.EntityManagerFactory;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory(){
        if (factory==null){


        }
        return factory;
    }
    public static void shutdown(){
        if (factory!=null){
            factory.close();
        }
    }
}
