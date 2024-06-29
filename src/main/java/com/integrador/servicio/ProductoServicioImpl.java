package com.integrador.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.entity.ProductoM;
import com.integrador.repositorio.ProductoRepositorio;

import java.util.List;
import java.util.Optional;


// interfaz de repo + interfaz de servicio : 
@Service  
public class ProductoServicioImpl implements ProductoServicio { // esta clase se imlementa deesde la interfaz producto servoice 

	// del repo la interfaz producto: 
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<ProductoM> obtenerTodosLosProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Optional<ProductoM> obtenerProductoPorId(Integer id) {
        return productoRepositorio.findById(id);
    }

    @Override
    public ProductoM guardarProducto(ProductoM producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public ProductoM actualizarProducto(ProductoM producto) {
        return productoRepositorio.save(producto);  // `save` actualiza si el producto ya existe
    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }
    @Override
    public boolean existePorNombre(String nombre) {
        return productoRepositorio.findByNombre(nombre) != null;
    }
    
    
}
