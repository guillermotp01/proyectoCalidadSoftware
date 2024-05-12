package com.example.Proyecto.Controladores;

import com.example.Proyecto.Clases.Categoria;
import com.example.Proyecto.Clases.Producto;
import com.example.Proyecto.Clases.Proveedor;
import com.example.Proyecto.Interfaces.InterProductoService;
import com.example.Proyecto.Repositorios.CategoriaRepository;
import com.example.Proyecto.Repositorios.ProveedorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/producto")
@Controller
public class ControladorProducto {

    @Autowired
    private InterProductoService servicio; // Para poder usar los metodos

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/listar")
	public String listarProductos(Model modelo) {
		modelo.addAttribute("productos", servicio.Listar());
		return "/Producto/listaProducto"; // nos retorna al archivo estudiantes
	}

    @GetMapping("/agregar")
    public String mostrarFormularioDeRegistrtarEstudiante(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);

        List<Categoria> categorias = categoriaRepository.findAll();
        List<Proveedor> proveedores = proveedorRepository.findAll();

        modelo.addAttribute("categorias", categorias);
        modelo.addAttribute("proveedores", proveedores);

        return "/Producto/nuevoProducto";
    }

	@PostMapping("/registrar")
	public String guardarProducto(@ModelAttribute("producto") Producto producto) {
		servicio.Guardar(producto);
		return "redirect:/producto/listar";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("producto", servicio.obtenerProductoPorId(id));

		List<Categoria> categorias = categoriaRepository.findAll();
        List<Proveedor> proveedores = proveedorRepository.findAll();

        modelo.addAttribute("categorias", categorias);
        modelo.addAttribute("proveedores", proveedores);
		
		return "/Producto/editarProducto";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizarEstudiante(@PathVariable int id, @ModelAttribute("producto") Producto producto,
			Model modelo) {
		Producto productoExistente = servicio.obtenerProductoPorId(id);
		productoExistente.setId_producto(id);
		productoExistente.setNombre(producto.getNombre());
		servicio.Actualizar(productoExistente);
		return "redirect:/producto/listar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarEstudiante(@PathVariable int id) {
		servicio.Eliminar(id);
		return "redirect:/producto/listar";
	}

    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable int id, Model modelo) {
        Producto producto = servicio.obtenerProductoPorId(id);
        modelo.addAttribute("producto", producto);
        return "/Producto/detalleProducto";
    }    
}