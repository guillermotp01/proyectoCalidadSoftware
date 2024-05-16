package com.example.Proyecto.Interfaces;

import com.example.Proyecto.Clases.Pedido;
import java.util.List;
import java.util.Optional;

public interface InterVenta {
    public List<Pedido> Listar();
    public Optional<Pedido> ConsultarId(int id);
    public void Guardar(Pedido p);
    public void Eliminar(int id);
    public List<Pedido> Buscar(String desc);
    public int UltimoIdVenta();
}