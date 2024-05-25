package com.example.Proyecto.Interfaces;

import com.example.Proyecto.Clases.MetodoPago;

import java.util.List;
import java.util.Optional;

public interface InterMedioPagoService {
    public List<MetodoPago> Listar();
    public Optional<MetodoPago> ConsultarId(int id);
    public void Guardar(MetodoPago c);
    public void Eliminar(int id);
    public List<MetodoPago> Buscar(String desc);
}
