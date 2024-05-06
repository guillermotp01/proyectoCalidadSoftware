
package com.example.Proyecto.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    public String nombre;
    public String apellido;
    public String dni;
    public String celular;
    public String correo;
    public String username;
    public String clave;
    public String direccion;
}
