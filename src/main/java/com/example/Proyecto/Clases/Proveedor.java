package com.example.Proyecto.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_proveedor;
    private String nombre;
    private int telefono;
}

