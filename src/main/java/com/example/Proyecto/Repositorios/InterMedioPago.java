package com.example.Proyecto.Repositorios;

import com.example.Proyecto.Clases.MedioPago;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterMedioPago extends CrudRepository<MedioPago,Integer>{

    @Query(value="SELECT * FROM Medio_Pago "
            + "WHERE nombre LIKE %?1% ",nativeQuery=true)
    public List<MedioPago> findForAll(String desc); 
}
