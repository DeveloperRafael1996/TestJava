package com.Test.demo.repository;
import com.Test.demo.dto.IEstados;
import com.Test.demo.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ComprobanteRepository extends JpaRepository<Comprobante, Integer> {
    public List<Comprobante> findByfecha(Date fecha);

    @Query(value = "select * from comprobante where estado =:estado", nativeQuery = true)
    public Optional<List<Comprobante>> findComprobanteByEstado(@Param("estado") String estado);

    @Query(value = "SELECT c.estado AS DescripcionComprobante, COUNT(c.*) AS TotalComprobante FROM comprobante AS c where c.fecha ='2020-11-20' GROUP BY c.estado ", nativeQuery = true)
    List<IEstados>countTotalComprobanteByEstadoNative();

}
