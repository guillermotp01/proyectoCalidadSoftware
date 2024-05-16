package com.example.Proyecto.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Clases.Proveedor;
import com.example.Proyecto.Interfaces.InterProveedor;
import com.example.Proyecto.Repositorios.ProveedorRepository;

@Service
public class ProveedorService implements InterProveedor{

    @Autowired
    private ProveedorRepository repositorio;

    @Override
    public List<Proveedor> Listar() {
        return repositorio.findAll();
    }
}
