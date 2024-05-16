package com.example.Proyecto.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Clases.Categoria;
import com.example.Proyecto.Interfaces.InterCategoria;
import com.example.Proyecto.Repositorios.CategoriaRepository;

@Service
public class CategoriaService implements InterCategoria{

    @Autowired
    private CategoriaRepository repositorio;

    @Override
    public List<Categoria> Listar() {
        return (List<Categoria>) repositorio.findAll();
    }
}
