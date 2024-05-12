package com.example.Proyecto.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Clases.DetallePedido;
import com.example.Proyecto.Interfaces.InterVentaDetalleService;
import com.example.Proyecto.Repositorios.InterVentaDetalle;

@Service
public class VentaDetalleService implements InterVentaDetalleService {

    @Autowired
    private InterVentaDetalle data;

    @Override
    public List<DetallePedido> Listar() {
        return (List<DetallePedido>) data.findAll();
    }

    @Override
    public Optional<DetallePedido> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(DetallePedido v) {
        data.save(v);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<DetallePedido> Buscar(String desc) {
        throw new UnsupportedOperationException("Unimplemented method 'Buscar'");
    }

    @Override
    public List<DetallePedido> BuscarPorIdVenta(int id) {
        return data.FindByIdVenta(id);
    }

}
