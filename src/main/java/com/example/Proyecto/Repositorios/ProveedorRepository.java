package com.example.Proyecto.Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyecto.Clases.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    
}