package com.Test.demo.controller;

import com.Test.demo.dto.IEstados;
import com.Test.demo.model.Comprobante;
import com.Test.demo.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/comprobantes")
public class ComprobanteController {
    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping("/all")
    public ResponseEntity<List<Comprobante>> getAll(){
        return new ResponseEntity<>(comprobanteService.getComprobante(), HttpStatus.OK);
    }
    @GetMapping("/rpt_es")
    public List<IEstados> getEstaod(){
        return comprobanteService.getCantidadEstado();
    }
    @GetMapping("report/{fecha}")
    public ResponseEntity<List<Comprobante>> getreport(@PathVariable Date fecha) {
        try {
            return new ResponseEntity<>(comprobanteService.getFecha(fecha), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("rpt_estado/{estado}")
    public ResponseEntity<List<Comprobante>> getreportestado(@PathVariable String estado) {
      return comprobanteService.getComprobanteEstado(estado)
              .map(comp -> new ResponseEntity<>(comp, HttpStatus.OK))
              .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
