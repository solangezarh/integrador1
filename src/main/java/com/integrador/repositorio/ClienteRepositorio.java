package com.integrador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.entity.ClienteM;

@Repository
public interface ClienteRepositorio extends JpaRepository<ClienteM, Integer> {
}
