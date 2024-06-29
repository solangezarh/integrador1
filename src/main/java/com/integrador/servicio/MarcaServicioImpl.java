package com.integrador.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.entity.MarcaM;
import com.integrador.repositorio.MarcaRepositorio;

@Service
public class MarcaServicioImpl implements MarcaServicio {

	// del repo la interfaz producto: 
    @Autowired
    private MarcaRepositorio marcaRepositorio;

    @Override
    public List<MarcaM> obtenerTodasLasMarcas() {
        return marcaRepositorio.findAll();
    }

    @Override
    public MarcaM obtenerMarcaPorId(int id) {
        return marcaRepositorio.findById(id).orElse(null);
    }

    @Override
    public MarcaM guardarMarca(MarcaM marca) {
        return marcaRepositorio.save(marca);
    }

    @Override
    public void eliminarMarca(int id) {
        marcaRepositorio.deleteById(id);
    }
    
    @Override
    public boolean existePorNombre(String nombre) {
        return marcaRepositorio.findByNombre(nombre) != null;
    }

}
