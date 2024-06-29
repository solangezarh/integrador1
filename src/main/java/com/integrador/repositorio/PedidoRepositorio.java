package com.integrador.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.entity.PedidoM;

@Repository
public interface PedidoRepositorio extends JpaRepository<PedidoM, Integer> {
}
