package com.integrador.restcontrolador;


/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integrador.entity.ProductoM;
import com.integrador.servicio.ProductoServicio;

import java.util.List;

@RestController
@RequestMapping("/api/productos") // Define la ruta base para todas las solicitudes manejadas por este controlador
public class ProductoControlador {

    @Autowired  // Inyección de dependencias para el servicio de productos
    private ProductoServicio productoServicio;

    @GetMapping  // Maneja solicitudes GET a /api/productos
    public List<ProductoM> obtenerTodosLosProductos() {
    	  // Llama al servicio para obtener todos los productos y los devuelve como una lista
          return productoServicio.obtenerTodosLosProductos();
    }


    @GetMapping("/{id}") // Maneja solicitudes GET a /api/productos/{id}
    public ResponseEntity<ProductoM> obtenerProductoPorId(@PathVariable int id) {
        // Llama al servicio para obtener un producto por su ID. 
        // El método map convierte el ProductoM encontrado en una respuesta HTTP 200 (OK)
        // Si no se encuentra el producto, orElseGet devuelve una respuesta HTTP 404 (Not Found)
      return productoServicio.obtenerProductoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping // Maneja solicitudes POST a /api/productos
    public ProductoM guardarProducto(@RequestBody ProductoM producto) {
    	// Llama al servicio para guardar un nuevo producto y lo devuelve en la respuesta
          return productoServicio.guardarProducto(producto);
    }

    @DeleteMapping("/{id}") // Maneja solicitudes DELETE a /api/productos/{id}
     public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
    	  // Llama al servicio para eliminar un producto por su ID
        productoServicio.eliminarProducto(id);
        // Devuelve una respuesta HTTP 204 (No Content) para indicar que la eliminación fue exitosa
        return ResponseEntity.noContent().build();
    }
}*/
