package com.example.Proyecto.Interfaces;

import com.example.Proyecto.Clases.Usuario;
import java.util.List;
import java.util.Optional;


public interface InterUsuario {
    public List<Usuario> Listar();
    public Optional<Usuario> ConsultarId(int id);
    public Usuario Guardar(Usuario c);
    public void Eliminar(int id);
    public List<Usuario> Buscar(String desc);
}
