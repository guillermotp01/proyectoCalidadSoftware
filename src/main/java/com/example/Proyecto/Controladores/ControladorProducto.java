package com.example.Proyecto.Controladores;

import com.example.Proyecto.Clases.Producto;
import com.example.Proyecto.Interfaces.InterProductoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/producto/")
@Controller
public class ControladorProducto {

    String carpeta = "Producto/";

    @Autowired
    private InterProductoService service; // Para poder usar los metodos

    @GetMapping("/nuevo") // localhost/nuevo
    public String nuevoProducto() {
        return carpeta + "nuevoProducto"; // nuevoProducto.html
    }

    @PostMapping("/registrar") // localhost/registrar
    public String RegistrarProducto(// @RequestParam("cod") int codigo,
            @RequestParam("nom") String nombre,
            @RequestParam("desc") String descripcion,
            @RequestParam("cat") String categoria,
            @RequestParam("marca") String marca,
            @RequestParam("pre") double precio,
            @RequestParam("img") String imagen_url,
            Model model) {
        // Aqui sera el proceso para registrar
        Producto p = new Producto();

        // p.setCodigo(codigo);
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setCategoria(categoria);
        p.setMarca(marca);
        p.setPrecio(precio);
        p.setImagen_url(imagen_url);
        // listaProd.add(p);
        service.Guardar(p);

        return listarProducto(model);
    }

    @GetMapping("/listar")
    public String listarProducto(Model model) {
        model.addAttribute("Producto", service.Listar());
        return carpeta + "listaProducto"; // listaProducto.html
    }

    @GetMapping("/eliminar")
    public String eliminarProducto(@RequestParam("cod") int codigo,
            Model model) {
        service.Eliminar(codigo);
        return listarProducto(model);
    }

    @PostMapping("/buscar")
    public String buscarProducto(@RequestParam("desc") String desc,
            Model model) {
        List<Producto> lc = service.Buscar(desc);
        model.addAttribute("Producto", lc);
        return carpeta + "listaProducto";
    }

    @GetMapping("/editar")
    public String editarProducto(@RequestParam("cod") int codigo,
            Model model) {
        Optional<Producto> prod = service.ConsultarId(codigo);
        model.addAttribute("Producto", prod);
        return carpeta + "editarProducto";
    }

    @PostMapping("/actualizar")
    public String actualizarProd(@RequestParam("id") int codigo,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("categoria") String categoria,
            @RequestParam("marca") String marca,
            @RequestParam("precio") double precio,
            @RequestParam("imagen_url") String imagen_url,
            Model model) {

        Producto p = new Producto();

        p.setId(codigo);
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setCategoria(categoria);
        p.setMarca(marca);
        p.setPrecio(precio);
        p.setImagen_url(imagen_url);

        service.Guardar(p);// cuando se envia el ID -> Actualizar

        return listarProducto(model);
    }

    @GetMapping("/detalle") // localhost/detalle
    public String detallarProducto(@RequestParam("cod") int codigo,
            Model model) {
        Optional<Producto> prod = service.ConsultarId(codigo);
        model.addAttribute("Producto", prod);
        return carpeta + "detalleProducto"; // detalleProducto.html
    }
}
