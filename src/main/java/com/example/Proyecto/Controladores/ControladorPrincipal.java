package com.example.Proyecto.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Proyecto.Clases.Usuario;

@Controller
public class ControladorPrincipal {
    @GetMapping("/") //localhost/
    public String menuPrincipal() {
        return "menuPrincipal"; //menuPrincipal.html
    }
    @GetMapping("/nosotros") //localhost/
    public String nosotrosVista() {
        return "Nosotros"; //Nosotros.html
    }
    @GetMapping("/acceso") //localhost/
    public String accesoVista() {
        return "Acceso"; //Acceso.html
    }
    @GetMapping("/nuevo") //localhost/
    public String nuevoUsuario() {
        return "nuevoUsuario"; //nuevoUsuario.html
    }
    @GetMapping("/carrito") //localhost/
    public String verCarrito() {
        return "/Venta/carritoCompra"; //
    }
    @GetMapping("/registro")
    public String Registrar(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);

        return "/Sesion/registro";
    }

    @GetMapping("/login")
    public String login() {
        return "/Sesion/login"; 
    }

    @GetMapping("/confirmacion")
    public String Confirmacion() {
        return "/Venta/confirmacionVenta"; 
    }
}
