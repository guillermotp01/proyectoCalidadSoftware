package com.example.Proyecto.Interfaces;

import com.example.Proyecto.Clases.VentaDetalle;
import java.util.List;
import java.util.Optional;

public interface InterVentaDetalleService {
    public List<VentaDetalle> Listar();
    public Optional<VentaDetalle> ConsultarId(int id);
    public void Guardar(VentaDetalle v);
    public void Eliminar(int id);
    public List<VentaDetalle> Buscar(String desc);
    public List<VentaDetalle> BuscarPorIdVenta(int id);
}
