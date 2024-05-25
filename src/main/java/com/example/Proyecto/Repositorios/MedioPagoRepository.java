package com.example.Proyecto.Repositorios;

import com.example.Proyecto.Clases.MetodoPago;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioPagoRepository extends JpaRepository<MetodoPago, Integer>{
    List<MetodoPago> findAllByNombre(String nombre);
}
