package com.example.Proyecto.Repositorios;

import com.example.Proyecto.Clases.Producto;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterProducto extends CrudRepository<Producto,Integer>{
    @Query(value="SELECT * FROM Producto "
            + "WHERE nombre LIKE %?1% "
            + "OR descripcion LIKE %?1% "
            + "OR categoria LIKE %?1% "
            + "OR marca LIKE %?1% "
            + "OR precio LIKE %?1% "
            + "OR imagen_url LIKE %?1%", nativeQuery=true)
    public List<Producto> findForAll(String desc);
}
