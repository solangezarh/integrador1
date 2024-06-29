package com.integrador.restcontrolador;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integrador.entity.CategoriaM;
import com.integrador.servicio.CategoriaServicio;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping
    public List<CategoriaM> obtenerTodasLasCategorias() {
        return categoriaServicio.obtenerTodasLasCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaM> obtenerCategoriaPorId(@PathVariable int id) {
        return categoriaServicio.obtenerCategoriaPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoriaM guardarCategoria(@RequestBody CategoriaM categoria) {
        return categoriaServicio.guardarCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable int id) {
        categoriaServicio.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
*/
