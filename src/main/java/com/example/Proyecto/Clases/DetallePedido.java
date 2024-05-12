package com.example.Proyecto.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="DetallePedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_detalle;
    private int cantidad;
    private BigDecimal precio_unitario;
    private BigDecimal precio_total;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
