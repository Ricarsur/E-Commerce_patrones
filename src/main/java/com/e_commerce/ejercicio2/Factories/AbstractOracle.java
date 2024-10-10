package com.e_commerce.ejercicio2.Factories;

import com.e_commerce.ejercicio2.domains.IProducto;
import com.e_commerce.ejercicio2.repositories.OracleProducto;

public class AbstractOracle implements IFactory {
    @Override
    public IProducto createProducto() {
        return new OracleProducto();
    }
}
