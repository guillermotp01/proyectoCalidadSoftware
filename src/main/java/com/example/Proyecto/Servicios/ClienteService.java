/*package com.example.Proyecto.Servicios;

import com.example.Proyecto.Clases.Cliente;
import com.example.Proyecto.Repositorios.ICliente;
import com.example.Proyecto.Interfaces.IClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private ICliente data;

    @Override
    public List<Cliente> Listar() {
        return (List<Cliente>) data.findAll();
    }

    @Override
    public Optional<Cliente> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Cliente c) {
        data.save(c);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Cliente> Buscar(String desc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
*/