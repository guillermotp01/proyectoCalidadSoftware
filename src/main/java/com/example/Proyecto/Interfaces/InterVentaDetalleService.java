package com.example.Proyecto.Interfaces;

import com.example.Proyecto.Clases.DetallePedido;
import java.util.List;
import java.util.Optional;

public interface InterVentaDetalleService {
    public List<DetallePedido> Listar();
    public Optional<DetallePedido> ConsultarId(int id);
    public void Guardar(DetallePedido v);
    public void Eliminar(int id);
    public List<DetallePedido> Buscar(String desc);
    public List<DetallePedido> BuscarPorIdVenta(int id);
}
