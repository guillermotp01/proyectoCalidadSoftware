package com.example.Proyecto.Repositorios;

import com.example.Proyecto.Clases.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliente extends CrudRepository<Cliente,Integer>{
    
}
