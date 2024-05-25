package com.example.Proyecto.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idCarrito; //id del carrito
    
    private int idProducto; //id del producto
    private String producto; //nombre del producto
    public String descripcion;
    private Double precio;
    private int cantidad;
    private Double total;
}
