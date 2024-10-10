package com.e_commerce.ejercicio2.Configurations;

import com.e_commerce.ejercicio2.Factories.IFactory;
import com.e_commerce.ejercicio2.Factories.AbstractMySQL;
import com.e_commerce.ejercicio2.Factories.AbstractOracle;

public class Config {
    public static IFactory configureAdapterDB(String dbType) {
        switch (dbType.toLowerCase()) {
            case "mysql":
                return new AbstractMySQL();
            case "oracle":
                return new AbstractOracle();
            default:
                throw new IllegalArgumentException("Motor de base de datos no soportado.");
        }
    }
}
