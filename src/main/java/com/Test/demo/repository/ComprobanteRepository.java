package com.Test.demo.repository;
import com.Test.demo.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;


import java.sql.Date;
import java.util.List;

public interface ComprobanteRepository extends JpaRepository<Comprobante, Integer> {
    public List<Comprobante> findByfecha(Date fecha);
}

