package com.integrador.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.entity.MarcaM;
import com.integrador.entity.ProductoM;

@Repository
public interface ProductoRepositorio extends JpaRepository<ProductoM, Integer> {
	Optional<ProductoM> findById(Integer id);
	 MarcaM findByNombre(String nombre);
	}
