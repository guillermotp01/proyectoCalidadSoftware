package com.example.Proyecto.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Clases.VentaDetalle;
import com.example.Proyecto.Interfaces.InterVentaDetalleService;
import com.example.Proyecto.Repositorios.InterVentaDetalle;

@Service
public class VentaDetalleService implements InterVentaDetalleService {

    @Autowired
    private InterVentaDetalle data;

    @Override
    public List<VentaDetalle> Listar() {
        return (List<VentaDetalle>) data.findAll();
    }

    @Override
    public Optional<VentaDetalle> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(VentaDetalle v) {
        data.save(v);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<VentaDetalle> Buscar(String desc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Buscar'");
    }

    @Override
    public List<VentaDetalle> BuscarPorIdVenta(int id) {
        return data.FindByIdVenta(id);
    }

}
