package com.example.Proyecto.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "carritoCompra"; //nuevoUsuario.html
    }
}
