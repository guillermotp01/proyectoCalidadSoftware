package com.example.Proyecto.Repositorios;

import com.example.Proyecto.Clases.DetallePedido;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterVentaDetalle extends CrudRepository<DetallePedido, Integer> {
        @Query(value = "SELECT * FROM Venta_Detalle "
                        + "WHERE venta_id = ?1", nativeQuery = true)
        public List<DetallePedido> FindByIdVenta(int id);
}
