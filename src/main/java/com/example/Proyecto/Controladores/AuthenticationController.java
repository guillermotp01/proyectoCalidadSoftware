/*package com.example.Proyecto.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Proyecto.Clases.JwtRequest;
import com.example.Proyecto.Clases.JwtResponse;
import com.example.Proyecto.Clases.Usuario;
import com.example.Proyecto.Servicios.UserDetailsServiceImpl;
import com.example.Proyecto.config.JwtUtils;

import java.security.Principal;

@Controller
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (DisabledException exception) {
            throw new Exception("Usuario deshabilitado: " + exception.getMessage()); // Mensaje de error más específico
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales inválidas: " + e.getMessage()); // Mensaje de error más específico
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception("Error durante la autenticación: " + exception.getMessage()); // Mensaje de error más específico
        }
    
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void autenticar(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException exception) {
            throw new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales invalidas " + e.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
*/