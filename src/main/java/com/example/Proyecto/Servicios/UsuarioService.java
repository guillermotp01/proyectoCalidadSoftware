package com.example.Proyecto.Servicios;

import com.example.Proyecto.Clases.Rol;
import com.example.Proyecto.Clases.Usuario;
import com.example.Proyecto.Repositorios.RolRepository;
import com.example.Proyecto.Repositorios.UsuarioRepository;
import com.example.Proyecto.Interfaces.InterUsuario;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements InterUsuario{

    @Autowired
    private UsuarioRepository repository;
    
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Usuario> Listar() {
        return (List<Usuario>) repository.findAll();
    }

    @Override
    public Optional<Usuario> ConsultarId(int id) {
        return repository.findById(id);
    }

    @Override
    public Usuario Guardar(Usuario c) {
        return repository.save(c);
    }

    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void Eliminar(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Usuario> Buscar(String desc) {
        throw new UnsupportedOperationException("Unimplemented method 'Buscar'");
    }
}
