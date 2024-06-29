package com.integrador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.entity.DetallePedidoM;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedidoM, Integer> {
}
