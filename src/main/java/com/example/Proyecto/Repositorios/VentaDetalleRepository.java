package com.example.Proyecto.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proyecto.Clases.DetallePedido;

public interface VentaDetalleRepository extends JpaRepository<DetallePedido, Integer> {
        List<DetallePedido> findByIdDetalle(int idDetalle);
}