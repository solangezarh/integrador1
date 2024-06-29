package com.integrador.restcontrolador;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integrador.entity.PedidoM;
import com.integrador.servicio.PedidoServicio;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoControlador {

    @Autowired
    private PedidoServicio pedidoServicio;

    @GetMapping
    public List<PedidoM> obtenerTodosLosPedidos() {
        return pedidoServicio.obtenerTodosLosPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoM> obtenerPedidoPorId(@PathVariable int id) {
        return pedidoServicio.obtenerPedidoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PedidoM guardarPedido(@RequestBody PedidoM pedido) {
        return pedidoServicio.guardarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable int id) {
        pedidoServicio.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
*/