package com.example.Proyecto.Clases;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Venta")
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    private Date fecha;
    
    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @ManyToOne()
    @JoinColumn(name="mediopago_id")
    private MedioPago mediopago;
    private double totalVenta;
}
