package com.example.Proyecto.Clases;

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
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id_producto;
    public String nombre;
    public String marca;
    public String descripcion;
    public double precio;
    public int stock;
    public String imagen_url;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
}
