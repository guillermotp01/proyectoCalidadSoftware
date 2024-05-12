/*package com.example.Proyecto.Servicios;

import com.example.Proyecto.Clases.MedioPago;
import com.example.Proyecto.Interfaces.InterMedioPagoService;
import com.example.Proyecto.Repositorios.InterMedioPago;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedioPagoService implements InterMedioPagoService{
    @Autowired
    private InterMedioPago data;

    @Override
    public List<MedioPago> Listar() {
        return (List<MedioPago>) data.findAll();
    }

    @Override
    public Optional<MedioPago> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(MedioPago mp) {
        data.save(mp);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<MedioPago> Buscar(String desc) {
        return data.findForAll(desc);
    }
}
*/