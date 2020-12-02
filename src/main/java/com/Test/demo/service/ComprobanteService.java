package com.Test.demo.service;


import com.Test.demo.dto.IEstados;
import com.Test.demo.model.Comprobante;
import com.Test.demo.repository.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ComprobanteService {

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    public List<Comprobante> getComprobante(){
        return comprobanteRepository.findAll();
    }
    public List<Comprobante> getFecha(Date fecha){
        return comprobanteRepository.findByfecha(fecha);
    }
    public Optional<List<Comprobante>> getComprobanteEstado(String estado){
        return comprobanteRepository.findComprobanteByEstado(estado);
    }
    public List<IEstados> getCantidadEstado(){
        return comprobanteRepository.countTotalComprobanteByEstadoNative();
    }
    public List<Comprobante> getComprobanteRepetidos(LocalDate fechahoy){
        return comprobanteRepository.countTotalComprobanteByRepetido(fechahoy);
    }
}
