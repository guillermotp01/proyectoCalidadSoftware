package com.example.Proyecto.Controladores;

import com.example.Proyecto.Clases.Categoria;
import com.example.Proyecto.Clases.Producto;
import com.example.Proyecto.Clases.Proveedor;
import com.example.Proyecto.Servicios.CategoriaService;
import com.example.Proyecto.Servicios.ProductoService;
import com.example.Proyecto.Servicios.ProveedorService;

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
    private ProductoService productoService; 

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/listar")
	public String listarProductos(Model modelo) {
		modelo.addAttribute("productos", productoService.Listar());
		return "/Producto/listaProducto"; 
	}

	@GetMapping("/listarAdmin")
	public String listarProductosAdmin(Model modelo) {
		modelo.addAttribute("productos", productoService.Listar());
		return "/Empleado/adminProductos"; 
	}

    @GetMapping("/agregar")
    public String formularioAgregar(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
		
        cargarCategoriasYProveedores(modelo);

        return "/Producto/nuevoProducto";
    }

	@PostMapping("/registrar")
	public String guardarProducto(@ModelAttribute("producto") Producto producto) {
		productoService.Guardar(producto);
		return "redirect:/producto/listar";
	}

	@GetMapping("/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("producto", productoService.obtenerProductoPorId(id));

		cargarCategoriasYProveedores(modelo);
		
		return "/Producto/editarProducto";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizarProducto(@PathVariable int id, @ModelAttribute("producto") Producto producto,
			Model modelo) {
		Producto productoExistente = productoService.obtenerProductoPorId(id);
		productoExistente.setId_producto(id);
		productoExistente.setNombre(producto.getNombre());
		productoService.Actualizar(productoExistente);
		return "redirect:/producto/listar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable int id) {
		productoService.Eliminar(id);
		return "redirect:/producto/listar";
	}

    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable int id, Model modelo) {
        Producto producto = productoService.obtenerProductoPorId(id);
        modelo.addAttribute("producto", producto);
        return "/Producto/detalleProducto";
    }   

	@PostMapping("/buscar")
    public String buscarProductosPorDesc(String desc, Model modelo) {
        List<Producto> productosEncontrados = productoService.Buscar(desc);
        modelo.addAttribute("productos", productosEncontrados);
        return "/Producto/listaProducto"; 
    }
	
	/*@PostMapping("/filtrar")
	public String filtrarProductosPorCategoria(@RequestParam("id_categoria") int id_categoria, Model modelo) {
		Categoria categoria = categoriaService.obtenerCategoriaPorId(id_categoria);
		List<Producto> productosFiltrados = productoService.findByCategoria(categoria);
		modelo.addAttribute("productos", productosFiltrados);
		return "/Producto/listaProducto"; 
	}
	*/

	private void cargarCategoriasYProveedores(Model modelo) {
		List<Categoria> categorias = categoriaService.Listar();
		List<Proveedor> proveedores = proveedorService.Listar();
	
		modelo.addAttribute("categorias", categorias);
		modelo.addAttribute("proveedores", proveedores);
	}
}