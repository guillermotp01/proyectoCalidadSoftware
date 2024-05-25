/*package com.example.Proyecto.Controladores;

import com.example.Proyecto.Clases.Usuario;
import com.example.Proyecto.Servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/registro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registerUser(@ModelAttribute Usuario usuario, Model model) {
        // Codificar la contraseña
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        
        // Guardar el usuario
        usuarioService.Guardar(usuario);
        
        model.addAttribute("registroExitoso", true);
        return "login";
    }
}*/
