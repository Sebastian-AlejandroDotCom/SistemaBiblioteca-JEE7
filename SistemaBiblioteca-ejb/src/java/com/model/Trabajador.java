/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "Trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t")
    , @NamedQuery(name = "Trabajador.findByRut", query = "SELECT t FROM Trabajador t WHERE t.rut = :rut")
    , @NamedQuery(name = "Trabajador.findByNombreTrabajador", query = "SELECT t FROM Trabajador t WHERE t.nombreTrabajador = :nombreTrabajador")
    , @NamedQuery(name = "Trabajador.findByApellidoPaterno", query = "SELECT t FROM Trabajador t WHERE t.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Trabajador.findByApellidoMaterno", query = "SELECT t FROM Trabajador t WHERE t.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Trabajador.findByFechaContratacion", query = "SELECT t FROM Trabajador t WHERE t.fechaContratacion = :fechaContratacion")})
public class Trabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rut")
    private Integer rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombreTrabajador")
    private String nombreTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaContratacion")
    @Temporal(TemporalType.DATE)
    private Date fechaContratacion;
    @OneToMany(mappedBy = "trabajadorInvolucrado")
    private List<Venta> ventaList;
    @OneToMany(mappedBy = "trabajadorInvolucrado")
    private List<Arriendo> arriendoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
    private List<TrabajadorTelefono> trabajadorTelefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
    private List<TrabajadorCorreo> trabajadorCorreoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
    private List<TrabajadorDireccion> trabajadorDireccionList;
    @OneToMany(mappedBy = "trabajadorInvolucrado")
    private List<Boleta> boletaList;

    public Trabajador() {
    }

    public Trabajador(Integer rut) {
        this.rut = rut;
    }

    public Trabajador(Integer rut, String nombreTrabajador, String apellidoPaterno, String apellidoMaterno, Date fechaContratacion) {
        this.rut = rut;
        this.nombreTrabajador = nombreTrabajador;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaContratacion = fechaContratacion;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<Arriendo> getArriendoList() {
        return arriendoList;
    }

    public void setArriendoList(List<Arriendo> arriendoList) {
        this.arriendoList = arriendoList;
    }

    @XmlTransient
    public List<TrabajadorTelefono> getTrabajadorTelefonoList() {
        return trabajadorTelefonoList;
    }

    public void setTrabajadorTelefonoList(List<TrabajadorTelefono> trabajadorTelefonoList) {
        this.trabajadorTelefonoList = trabajadorTelefonoList;
    }

    @XmlTransient
    public List<TrabajadorCorreo> getTrabajadorCorreoList() {
        return trabajadorCorreoList;
    }

    public void setTrabajadorCorreoList(List<TrabajadorCorreo> trabajadorCorreoList) {
        this.trabajadorCorreoList = trabajadorCorreoList;
    }

    @XmlTransient
    public List<TrabajadorDireccion> getTrabajadorDireccionList() {
        return trabajadorDireccionList;
    }

    public void setTrabajadorDireccionList(List<TrabajadorDireccion> trabajadorDireccionList) {
        this.trabajadorDireccionList = trabajadorDireccionList;
    }

    @XmlTransient
    public List<Boleta> getBoletaList() {
        return boletaList;
    }

    public void setBoletaList(List<Boleta> boletaList) {
        this.boletaList = boletaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Trabajador[ rut=" + rut + " ]";
    }
    
}
