package com.integrador.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.integrador.servicio.MarcaServicio;
import com.integrador.entity.MarcaM;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/marcas") //ruta parae lhtml
public class MarcaC {

    @Autowired
    private MarcaServicio marcaServicio;

    
    
    @GetMapping("/")// sto es necesario para q se muestre en el html desde templantes 
    public String mostrarFormularioNuevaMarca(Model model) {
        MarcaM nuevaMarca = new MarcaM();
        model.addAttribute("marca", nuevaMarca);
        
        List<MarcaM> marcas = marcaServicio.obtenerTodasLasMarcas();  // Obtiene todas las marcas
        model.addAttribute("listMarcas", marcas);  // Añade la lista de marcas al modelo
        
        return "add_marca"; // Devuelve el nombre de la vista para crear una nueva marca
    }
    
    
  

    
    

   

    // Maneja solicitudes POST a /marcas/guardar
    @PostMapping("/guardar") //ruta del form marcas/guardar
    public String guardarMarca(@Valid @ModelAttribute MarcaM marca, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
    	  // Verificar errores de validación
    	   if (bindingResult.hasErrors()) {
            // Si hay errores de validación, vuelve a cargar el formulario con los errores
            model.addAttribute("listMarcas", marcaServicio.obtenerTodasLasMarcas());
            return "redirect:/marcas/";
        }

        // Verificación de unicidad del nombre de la marca
        if (marcaServicio.existePorNombre(marca.getNombre())) {
            // Rechazar el valor del campo "nombre" y volver al formulario de agregar marca con el mensaje de error
            bindingResult.rejectValue("nombre", "error.marca", "El nombre de la marca ya existe");
            return "redirect:/marcas/";
        }

        // Si no hay errores de validación y no existe una marca con ese nombre, guardar la marca
        marcaServicio.guardarMarca(marca);

        
        // Agregar mensaje de éxito para mostrar en la página de listado de marcas
        redirectAttributes.addFlashAttribute("mensaje", "Marca guardada correctamente");

        
        // Redirigir a la misma página para mostrar la marca recién agregada
        return "redirect:/marcas/"; // Ajusta la ruta según donde visualices la lista actualizada
 }

    

    // Maneja solicitudes GET a /marcas/editar/{id}
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarMarca(@PathVariable int id, Model model) {
    	  MarcaM marca = marcaServicio.obtenerMarcaPorId(id);
          if (marca != null) {
            model.addAttribute("marca", marca);
            List<MarcaM> marcas = marcaServicio.obtenerTodasLasMarcas();
            model.addAttribute("listMarcas", marcas);

            return "add_marca";
            } else {
            return "redirect:/marcas/"; // Redirige a la lista de marcas si no se encuentra la marca
        }
    }

    /*
    // Maneja solicitudes POST a /marcas/actualizar/{id}
    @PostMapping("/actualizar/{id}")
    public String actualizarMarca(@PathVariable int id, @ModelAttribute MarcaM marca) {
        MarcaM marcaExistente = marcaServicio.obtenerMarcaPorId(id);
        if (marcaExistente != null) {
            marca.setIdMarca(id); // Asegura que la ID se mantenga igual
            marcaServicio.guardarMarca(marca);
        }
        return "redirect:/marcas"; // Redirige a la lista de marcas después de actualizar
    }
*/
    // Maneja solicitudes GET a /marcas/eliminar/{id}
    @GetMapping("/eliminar/{id}")
    public String eliminarMarca(@PathVariable int id) {
        marcaServicio.eliminarMarca(id);
        return "redirect:/marcas/"; // Redirige a la lista de marcas después de eliminar
    }
    
    
}
