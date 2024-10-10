package com.e_commerce.ejercicio2.repositories;

import com.e_commerce.ejercicio2.domains.IProducto;
import com.e_commerce.ejercicio2.domains.Producto;

import java.util.ArrayList;
import java.util.List;

public class MySQLProducto implements IProducto {
    private List<Producto> productos = new ArrayList<>();

    public MySQLProducto() {
        productos.add(new Producto(1, "Producto MySQL 1", 10.0));
        productos.add(new Producto(2, "Producto MySQL 2", 20.0));
    }
    @Override
    public List<Producto> getAll() {
        return productos;
    }

    @Override
    public Producto getById(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void add(Producto producto) {
        productos.add(producto);
    }

    @Override
    public void update(Producto producto) {
        Producto existing = getById(producto.getId());
        if (existing != null) {
            existing.setDescripcion(producto.getDescripcion());
            existing.setPrecio(producto.getPrecio());
        }
    }

    @Override
    public void delete(int id) {
        productos.removeIf(p -> p.getId() == id);
    }
}
