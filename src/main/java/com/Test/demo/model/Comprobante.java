package com.Test.demo.model;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "comprobante")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante")
    private Integer id_comprobante;
    @Column(name = "comp_serie_correlativo")
    private String comp_serie_correlativo;

    @Column(name = "recep_numero_documento")
    private String recep_numero_documento;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha")
    private Date fecha;

    private String usuario_creacion;

    public Integer getId_comprobante() {
        return id_comprobante;
    }

    public void setId_comprobante(Integer id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    public String getComp_serie_correlativo() {
        return comp_serie_correlativo;
    }

    public void setComp_serie_correlativo(String comp_serie_correlativo) {
        this.comp_serie_correlativo = comp_serie_correlativo;
    }
    public String getRecep_numero_documento() {
        return recep_numero_documento;
    }
    public void setRecep_numero_documento(String recep_numero_documento) {
        this.recep_numero_documento = recep_numero_documento;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getUsuario_creacion() {
        return usuario_creacion;
    }
    public void setUsuario_creacion(String usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }
}
