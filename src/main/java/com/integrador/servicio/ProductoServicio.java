package com.integrador.servicio;

import java.util.List;
import java.util.Optional;

import com.integrador.entity.ProductoM;

public interface ProductoServicio { // todo del repo
	//optional para el .map para el restC
    List<ProductoM> obtenerTodosLosProductos();
    Optional<ProductoM> obtenerProductoPorId(Integer id); // Devuelve Optional
     ProductoM guardarProducto(ProductoM producto);
    ProductoM actualizarProducto(ProductoM producto);
    void eliminarProducto(Integer id);
    boolean existePorNombre(String nombre); // Método para verificar la unicidad
}
