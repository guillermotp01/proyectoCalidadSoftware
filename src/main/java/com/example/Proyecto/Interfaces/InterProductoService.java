package com.example.Proyecto.Interfaces;

import com.example.Proyecto.Clases.Producto;
import java.util.List;
import java.util.Optional;

public interface InterProductoService {
    public List<Producto> Listar();
    public Optional<Producto> ConsultarId(int id);
    public void Guardar(Producto p);
    public void Eliminar(int id);
    public List<Producto> Buscar(String desc);
}
