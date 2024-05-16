/*package com.example.Proyecto.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.Proyecto.Clases.Usuario;
import com.example.Proyecto.Repositorios.UsuarioRepository;


@Component
public class CustomUsersDetailsService implements AuthenticationProvider {

    @Autowired
    private UsuarioRepository userRepository; // Por ejemplo, suponiendo que tienes un repositorio de usuarios

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Aquí deberías realizar la lógica de autenticación, por ejemplo, consultando en la base de datos
        // Si la autenticación es exitosa, devuelves un objeto Authentication con los roles del usuario
        // Si la autenticación falla, lanzas una excepción AuthenticationException

        // Ejemplo de autenticación básica
        Usuario user = userRepository.findByUsername(username);
        if (user != null && password.equals(user.getClave())) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            // Aquí puedes agregar los roles del usuario, por ejemplo:
            // authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new UsernamePasswordAuthenticationToken(username, password, authorities);
        } else {
            throw new BadCredentialsException("Credenciales inválidas");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}*/