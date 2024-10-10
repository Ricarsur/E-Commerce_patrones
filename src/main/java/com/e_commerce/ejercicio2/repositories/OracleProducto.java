package com.e_commerce.ejercicio2.repositories;

import com.e_commerce.ejercicio2.domains.IProducto;
import com.e_commerce.ejercicio2.domains.Producto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OracleProducto implements IProducto {
    private Map<Integer, Producto> productos = new HashMap<>();

    public OracleProducto() {

    }

    @Override
    public List<Producto> getAll() {
        return productos.values().stream().collect(Collectors.toList());
    }

    @Override
    public Producto getById(int id) {
        return productos.get(id);
    }

    @Override
    public void add(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public void update(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public void delete(int id) {
        productos.remove(id);
    }
}
