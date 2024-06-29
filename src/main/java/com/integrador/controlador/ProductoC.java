package com.integrador.controlador;

import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.integrador.servicio.CategoriaServicio;
import com.integrador.servicio.MarcaServicio;
import com.integrador.servicio.ProductoServicio;


import jakarta.validation.Valid;

import com.integrador.entity.CategoriaM;
import com.integrador.entity.MarcaM;
import com.integrador.entity.ProductoM;

//@RequestMapping
// Define el prefijo de las rutas manejadas por este controlador

@Controller
@RequestMapping("/productos")
public class ProductoC {

	@Autowired // Inyección de dependencias para el servicio de productos
	private ProductoServicio productoServicio;

	  @Autowired
	    private MarcaServicio marcaServicio;
	  
	@Autowired
	private CategoriaServicio categoriaServicio;

	@GetMapping("/") // Maneja solicitudes GET a /productos/listar
	public String listarProductos(Model model) {
		// list del objeto ProductoM , en el primer autowired,
		List<ProductoM> productos = productoServicio.obtenerTodosLosProductos();
		// para enviar la lista o obj al formulario
		model.addAttribute("listProducts", productos); // listproduct es el nombre con el q enviamos la lista en el
			
	      // Agregar un nuevo objeto ProductoM para el formulario de creación
        model.addAttribute("producto", new ProductoM());

        // Obtener y enviar las categorías y marcas disponibles al formulario
        List<CategoriaM> categorias = categoriaServicio.obtenerTodasLasCategorias();
        List<MarcaM> marcas = marcaServicio.obtenerTodasLasMarcas();
        model.addAttribute("categorias", categorias);
        model.addAttribute("marcas", marcas);

        
		// tbody del html
		return "add_producto"; // Devuelve el nombre de la vista que se debe renderizar (por ejemplo,
						// "productoss.html")
	}
	



	 @PostMapping("/guardarProducto")
	    public String guardarProducto(@Valid @ModelAttribute ProductoM producto,
	                                  @RequestParam("imagen") MultipartFile archivo,
	                                  BindingResult result,
	                                  RedirectAttributes redirectAttributes) {
	        if (result.hasErrors()) {
	            // Manejo de errores de validación
	            return "add_producto";
	        }

	        if (archivo != null && !archivo.isEmpty()) {
	            try {
	                String nombreArchivo = StringUtils.cleanPath(archivo.getOriginalFilename());
	                String directorioImagenes = "img_productos/";
	                String rutaCompleta = Paths.get("src", "main", "resources", "static", directorioImagenes).toString();

	                File directorio = new File(rutaCompleta);
	                if (!directorio.exists()) {
	                    directorio.mkdirs();
	                }

	                Path rutaArchivo = Paths.get(rutaCompleta, nombreArchivo);
	                Files.copy(archivo.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);

	                producto.setImagen("/" + directorioImagenes + nombreArchivo);
	            } catch (IOException e) {
	                e.printStackTrace();
	                redirectAttributes.addFlashAttribute("error", "Error al subir la imagen: " + e.getMessage());
	                return "redirect:/productos/";
	            }
	        }

	        productoServicio.guardarProducto(producto);
	        redirectAttributes.addFlashAttribute("mensaje", "Producto guardado exitosamente");
	        return "redirect:/productos/";
	    } 


	

	  
//para el form

	/*
 	@PostMapping("guardarProducto")
	public String guardarProducto( @ModelAttribute ProductoM producto, 
           
            Model model
          ) {
		
	
	     // Llama al servicio para guardar el producto
        productoServicio.guardarProducto(producto);
        // Redirige a la lista de productos después de guardar
        return "redirect:/productos/";
	}
	*/

	  
	   
	   
	   
	  @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Optional<ProductoM> producto = productoServicio.obtenerProductoPorId(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            List<CategoriaM> categorias = categoriaServicio.obtenerTodasLasCategorias();
            List<MarcaM> marcas = marcaServicio.obtenerTodasLasMarcas();
            model.addAttribute("categorias", categorias);
            model.addAttribute("marcas", marcas);
            return "add_producto";
        } else {
            // Manejo de error si no se encuentra el producto
            return "redirect:/productos/";
        }
    }
    

   

 
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoServicio.eliminarProducto(id);
        return "redirect:/productos/";
    }

    
    
}
