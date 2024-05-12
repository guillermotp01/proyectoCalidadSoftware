package com.example.Proyecto.Repositorios;

import com.example.Proyecto.Clases.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{

}
