package com.example.Proyecto.Interfaces;

import com.example.Proyecto.Clases.Producto;
import java.util.List;
import java.util.Optional;


public interface InterProducto {
    public List<Producto> Listar();
    public Producto obtenerProductoPorId(int id);
    public Producto Guardar(Producto p);
    public void Eliminar(int id);
    public Producto Actualizar(Producto p);
    public Optional<Producto> ConsultarId(int id);
    public List<Producto> Buscar(String desc);
    /*public List<Producto> Filtrar(int id_categoria);*/
}
