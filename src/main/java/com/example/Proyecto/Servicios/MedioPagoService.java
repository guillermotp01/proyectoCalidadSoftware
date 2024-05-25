package com.example.Proyecto.Servicios;


import com.example.Proyecto.Clases.MetodoPago;
import com.example.Proyecto.Interfaces.InterMedioPagoService;
import com.example.Proyecto.Repositorios.MedioPagoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedioPagoService implements InterMedioPagoService{
    
    @Autowired
    private MedioPagoRepository data;

    @Override
    public List<MetodoPago> Listar() {
        return (List<MetodoPago>) data.findAll();
    }

    @Override
    public Optional<MetodoPago> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(MetodoPago mp) {
        data.save(mp);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<MetodoPago> Buscar(String nombre) {
        return data.findAllByNombre(nombre);
    }
}
