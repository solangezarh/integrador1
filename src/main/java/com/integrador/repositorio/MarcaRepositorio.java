package com.integrador.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.entity.MarcaM;

@Repository
public interface MarcaRepositorio extends JpaRepository<MarcaM, Integer> {
	 MarcaM findByNombre(String nombre);
	 // Aquí puedes definir consultas personalizadas si es necesario
}
