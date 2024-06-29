package com.integrador.servicio;

import java.util.List;
import java.util.Optional;

import com.integrador.entity.MarcaM;
import com.integrador.entity.ProductoM;

public interface MarcaServicio {
	//optional para el .map del restC
    List<MarcaM> obtenerTodasLasMarcas();
    MarcaM obtenerMarcaPorId(int id);
    MarcaM guardarMarca(MarcaM marca);
    void eliminarMarca(int id);
    boolean existePorNombre(String nombre); // Método para verificar la unicidad

}
