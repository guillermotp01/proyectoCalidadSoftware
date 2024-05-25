package com.example.Proyecto.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyecto.Clases.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
}