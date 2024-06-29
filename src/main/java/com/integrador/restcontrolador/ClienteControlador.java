package com.integrador.restcontrolador;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integrador.entity.ClienteM;
import com.integrador.servicio.ClienteServicio;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public List<ClienteM> obtenerTodosLosClientes() {
        return clienteServicio.obtenerTodosLosClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteM> obtenerClientePorId(@PathVariable int id) {
        return clienteServicio.obtenerClientePorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClienteM guardarCliente(@RequestBody ClienteM cliente) {
        return clienteServicio.guardarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable int id) {
        clienteServicio.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
*/
