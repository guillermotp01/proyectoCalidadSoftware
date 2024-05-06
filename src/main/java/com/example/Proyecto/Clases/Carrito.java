package com.example.Proyecto.Clases;

import lombok.Data;

@Data
public class Carrito {
    private int idProducto; //id del producto
    private String producto; //nombre del producto
    public String descripcion;
    private Double precio;
    private Double cantidad;
    private Double total;
}
