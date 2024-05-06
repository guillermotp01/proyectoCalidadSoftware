package com.example.Proyecto.Servicios;

import com.example.Proyecto.Clases.Producto;
import com.example.Proyecto.Interfaces.InterProductoService;
import com.example.Proyecto.Repositorios.InterProducto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements InterProductoService{

    @Autowired
    private InterProducto data;

    @Override
    public List<Producto> Listar() {
        return (List<Producto>) data.findAll();
    }

    @Override
    public Optional<Producto> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Producto p) {
        data.save(p);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Producto> Buscar(String desc) {
        return data.findForAll(desc);
    }  
}
