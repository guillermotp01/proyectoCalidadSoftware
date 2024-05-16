package com.example.Proyecto.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Clases.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    Usuario findByUsername(String nombre);
}
