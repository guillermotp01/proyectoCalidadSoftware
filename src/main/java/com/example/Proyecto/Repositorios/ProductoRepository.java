package com.example.Proyecto.Repositorios;

import com.example.Proyecto.Clases.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombre(String nombre);
}
