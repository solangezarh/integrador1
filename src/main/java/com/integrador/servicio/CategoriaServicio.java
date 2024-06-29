package com.integrador.servicio;

import java.util.List;
import com.integrador.entity.CategoriaM;

public interface CategoriaServicio {
    List<CategoriaM> obtenerTodasLasCategorias();
    CategoriaM obtenerCategoriaPorId(int id);
    void guardarCategoria(CategoriaM categoria);
    void eliminarCategoria(int id);
    boolean existePorNombre(String nombre);
}