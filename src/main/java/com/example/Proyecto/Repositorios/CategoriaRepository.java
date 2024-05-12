package com.example.Proyecto.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Proyecto.Clases.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}
