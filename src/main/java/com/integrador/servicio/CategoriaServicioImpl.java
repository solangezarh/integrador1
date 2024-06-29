package com.integrador.servicio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.integrador.entity.CategoriaM;
import com.integrador.repositorio.CategoriaRepositorio;
import com.integrador.servicio.CategoriaServicio;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public List<CategoriaM> obtenerTodasLasCategorias() {
        return categoriaRepositorio.findAll();
    }

    @Override
    public CategoriaM obtenerCategoriaPorId(int id) {
        Optional<CategoriaM> optionalCategoria = categoriaRepositorio.findById(id);
        return optionalCategoria.orElse(null);
    }

    @Override
    public void guardarCategoria(CategoriaM categoria) {
        categoriaRepositorio.save(categoria);
    }

    @Override
    public void eliminarCategoria(int id) {
        categoriaRepositorio.deleteById(id);
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return categoriaRepositorio.existsByNombre(nombre);
    }
}
