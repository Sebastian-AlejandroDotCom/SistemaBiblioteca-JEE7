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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Distribuidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribuidor.findAll", query = "SELECT d FROM Distribuidor d")
    , @NamedQuery(name = "Distribuidor.findByRut", query = "SELECT d FROM Distribuidor d WHERE d.rut = :rut")
    , @NamedQuery(name = "Distribuidor.findByNombreEmpresa", query = "SELECT d FROM Distribuidor d WHERE d.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Distribuidor.findByA\u00f1oInicioVentas", query = "SELECT d FROM Distribuidor d WHERE d.a\u00f1oInicioVentas = :a\u00f1oInicioVentas")})
public class Distribuidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rut")
    private Integer rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a\u00f1oInicioVentas")
    @Temporal(TemporalType.DATE)
    private Date añoInicioVentas;
    @JoinColumn(name = "direccion", referencedColumnName = "idDireccion")
    @ManyToOne
    private Direccion direccion;
    @JoinColumn(name = "telefono", referencedColumnName = "idTelefono")
    @ManyToOne
    private Telefono telefono;
    @OneToMany(mappedBy = "distribuidorInvolucrado")
    private List<Compra> compraList;
    @OneToMany(mappedBy = "distribuidorInvolucrado")
    private List<Factura> facturaList;

    public Distribuidor() {
    }

    public Distribuidor(Integer rut) {
        this.rut = rut;
    }

    public Distribuidor(Integer rut, String nombreEmpresa, Date añoInicioVentas) {
        this.rut = rut;
        this.nombreEmpresa = nombreEmpresa;
        this.añoInicioVentas = añoInicioVentas;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Date getAñoInicioVentas() {
        return añoInicioVentas;
    }

    public void setAñoInicioVentas(Date añoInicioVentas) {
        this.añoInicioVentas = añoInicioVentas;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
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
        if (!(object instanceof Distribuidor)) {
            return false;
        }
        Distribuidor other = (Distribuidor) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Distribuidor[ rut=" + rut + " ]";
    }
    
}
