package com.e_commerce.ejercicio2.domains;

import java.util.List;

public interface IProducto {
    List<Producto> getAll();
    Producto getById(int id);
    void add(Producto producto);
    void update(Producto producto);
    void delete(int id);
}
