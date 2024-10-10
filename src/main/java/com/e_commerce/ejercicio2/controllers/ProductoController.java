package com.e_commerce.ejercicio2.controllers;

import com.e_commerce.ejercicio2.Configurations.Config;
import com.e_commerce.ejercicio2.domains.IProducto;
import com.e_commerce.ejercicio2.domains.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private IProducto productos;
    public ProductoController() {
        productos = Config.configureAdapterDB("oracle").createProducto();
    }
    @GetMapping
    public List<Producto> getAll() {
        return productos.getAll();
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable int id) {
        return productos.getById(id);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Producto producto) {
        if (getById(producto.getId()) == null) {
            productos.add(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Producto agregado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El producto ya existe.");
        }
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Producto producto) {
        producto.setId(id);
        productos.update(producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productos.delete(id);

    }

}
