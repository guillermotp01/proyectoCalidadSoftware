package com.example.Proyecto.Interfaces;

import com.example.Proyecto.Clases.Venta;
import java.util.List;
import java.util.Optional;

public interface InterVentaService {
    public List<Venta> Listar();
    public Optional<Venta> ConsultarId(int id);
    public void Guardar(Venta p);
    public void Eliminar(int id);
    public List<Venta> Buscar(String desc);
    public int UltimoIdVenta();
}
