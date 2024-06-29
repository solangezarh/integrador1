package com.integrador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.entity.CategoriaM;

@Repository
public interface CategoriaRepositorio extends JpaRepository<CategoriaM, Integer> {
	 boolean existsByNombre(String nombre);
	 }
