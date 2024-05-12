package com.example.Proyecto.Servicios;

import com.example.Proyecto.Clases.Pedido;
import com.example.Proyecto.Interfaces.InterVentaService;
import com.example.Proyecto.Repositorios.InterVenta;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements InterVentaService{

    @Autowired
    private InterVenta data;

    @Override
    public List<Pedido> Listar() {
        return (List<Pedido>) data.findAll();
    }

    @Override
    public Optional<Pedido> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Pedido v) {
        data.save(v);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Pedido> Buscar(String desc) {
        return data.findForAll(desc);
    }

    @Override
    public int UltimoIdVenta() {
        return data.ConsultarIdVenta();
    } 
}
