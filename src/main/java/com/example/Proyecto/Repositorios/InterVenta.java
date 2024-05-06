package com.example.Proyecto.Repositorios;

import com.example.Proyecto.Clases.Venta;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterVenta extends CrudRepository<Venta,Integer>{
    @Query(value = "SELECT id FROM Venta "
            + "ORDER BY id DESC "
            + "LIMIT 1", nativeQuery = true)
    public int ConsultarIdVenta();
    
    @Query(value="SELECT * FROM Venta "
            + "WHERE id_Producto LIKE %?1% "
            + "OR nombre LIKE %?1% "
            + "OR descripcion LIKE %?1% "
            + "OR cantidad LIKE %?1% "
            + "OR precio LIKE %?1% ",nativeQuery=true)
    public List<Venta> findForAll(String desc); 
}
