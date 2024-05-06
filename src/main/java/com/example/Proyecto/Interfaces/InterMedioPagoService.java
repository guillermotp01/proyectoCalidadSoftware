package com.example.Proyecto.Interfaces;

import com.example.Proyecto.Clases.MedioPago;
import java.util.List;
import java.util.Optional;

public interface InterMedioPagoService {
    public List<MedioPago> Listar();
    public Optional<MedioPago> ConsultarId(int id);
    public void Guardar(MedioPago c);
    public void Eliminar(int id);
    public List<MedioPago> Buscar(String desc);
}
