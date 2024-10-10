package com.e_commerce.ejercicio2.Factories;

import com.e_commerce.ejercicio2.domains.IProducto;
import com.e_commerce.ejercicio2.repositories.MySQLProducto;

public class AbstractMySQL implements IFactory {

    @Override
    public IProducto createProducto() {
        return new MySQLProducto();
    }
}
