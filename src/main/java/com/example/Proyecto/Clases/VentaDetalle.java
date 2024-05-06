package com.example.Proyecto.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "VentaDetalle")
@Data
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double cantidad;
    private Double precio;
    private Double total;

    @ManyToOne()
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne()
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private String descripcion;
}