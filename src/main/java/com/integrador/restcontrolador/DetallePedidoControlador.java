package com.integrador.restcontrolador;


/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integrador.entity.DetallePedidoM;
import com.integrador.servicio.DetallePedidoServicio;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-pedido")
public class DetallePedidoControlador {

    @Autowired
    private DetallePedidoServicio detallePedidoServicio;

    @GetMapping
    public List<DetallePedidoM> obtenerTodosLosDetallesPedidos() {
        return detallePedidoServicio.obtenerTodosLosDetallesPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoM> obtenerDetallePedidoPorId(@PathVariable int id) {
        return detallePedidoServicio.obtenerDetallePedidoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetallePedidoM guardarDetallePedido(@RequestBody DetallePedidoM detallePedido) {
        return detallePedidoServicio.guardarDetallePedido(detallePedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetallePedido(@PathVariable int id) {
        detallePedidoServicio.eliminarDetallePedido(id);
        return ResponseEntity.noContent().build();
    }
}
*/
