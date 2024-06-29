package com.integrador.controlador;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.integrador.servicio.CategoriaServicio;
import com.integrador.entity.CategoriaM;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/categorias") //ruta parae lhtml
public class CategoriaC {

    @Autowired
    private CategoriaServicio categoriaServicio;

    
    
    @GetMapping("/") // Muestra el formulario de nueva categoría y la lista de categorías
    public String mostrarFormularioNuevaCategoria(Model model) {
        CategoriaM nuevaCategoria = new CategoriaM();
        model.addAttribute("categoria", nuevaCategoria);

        List<CategoriaM> categorias = categoriaServicio.obtenerTodasLasCategorias();
        model.addAttribute("listCategorias", categorias);

        return "add_categoria"; // Devuelve el nombre de la vista para crear una nueva categoría
    }
    

    @PostMapping("/guardar") // Ruta del formulario categorias/guardar
    public String guardarCategoria(@Valid @ModelAttribute CategoriaM categoria, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        // Verificar errores de validación
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, vuelve a cargar el formulario con los errores
            model.addAttribute("listCategorias", categoriaServicio.obtenerTodasLasCategorias());
            return "redirect:/categorias/";
        }

        // Verificación de unicidad del nombre de la categoría
        if (categoriaServicio.existePorNombre(categoria.getNombre())) {
            // Rechazar el valor del campo "nombre" y volver al formulario de agregar categoría con el mensaje de error
            bindingResult.rejectValue("nombre", "error.categoria", "El nombre de la categoría ya existe");
            return "redirect:/categorias/";
        }

        // Si no hay errores de validación y no existe una categoría con ese nombre, guardar la categoría
        categoriaServicio.guardarCategoria(categoria);

        // Agregar mensaje de éxito para mostrar en la página de listado de categorías
        redirectAttributes.addFlashAttribute("mensaje", "Categoría guardada correctamente");

        // Redirigir a la misma página para mostrar la categoría recién agregada
        return "redirect:/categorias/";
    }

    

    @GetMapping("/editar/{id}") // Muestra el formulario de edición de categoría
    public String mostrarFormularioEditarCategoria(@PathVariable int id, Model model) {
        CategoriaM categoria = categoriaServicio.obtenerCategoriaPorId(id);
        if (categoria != null) {
            model.addAttribute("categoria", categoria);
            List<CategoriaM> categorias = categoriaServicio.obtenerTodasLasCategorias();
            model.addAttribute("listCategorias", categorias);

            return "add_categoria";
        } else {
            return "redirect:/categorias/"; // Redirige a la lista de categorías si no se encuentra la categoría
        }
    }

    @GetMapping("/eliminar/{id}") // Elimina una categoría por ID
    public String eliminarCategoria(@PathVariable int id) {
        categoriaServicio.eliminarCategoria(id);
        return "redirect:/categorias/"; // Redirige a la lista de categorías después de eliminar
    }
    
}
