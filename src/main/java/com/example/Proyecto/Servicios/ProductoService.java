package com.example.Proyecto.Servicios;

import com.example.Proyecto.Clases.Producto;
import com.example.Proyecto.Interfaces.InterProductoService;
import com.example.Proyecto.Repositorios.ProductoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements InterProductoService{

    @Autowired
    private ProductoRepository repositorio;

    @Override
	public List<Producto> Listar() {
		return repositorio.findAll();
	}

	@Override
	public Producto Guardar(Producto producto) {
		return repositorio.save(producto);
	}

	@Override
	public Producto obtenerProductoPorId(int id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Producto Actualizar(Producto producto) {
		return repositorio.save(producto);
	}

	@Override
	public void Eliminar(int id) {
		repositorio.deleteById(id);
	}

	@Override
    public Optional<Producto> ConsultarId(int id) {
        return repositorio.findById(id);
    }
}
