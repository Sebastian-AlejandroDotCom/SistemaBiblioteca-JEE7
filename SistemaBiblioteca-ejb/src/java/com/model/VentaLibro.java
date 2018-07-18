/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "Venta_Libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaLibro.findAll", query = "SELECT v FROM VentaLibro v")
    , @NamedQuery(name = "VentaLibro.findByIdVentaLibro", query = "SELECT v FROM VentaLibro v WHERE v.idVentaLibro = :idVentaLibro")})
public class VentaLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVentaLibro")
    private Integer idVentaLibro;
    @JoinColumn(name = "libro", referencedColumnName = "numeroSerie")
    @ManyToOne(optional = false)
    private Libro libro;
    @JoinColumn(name = "venta", referencedColumnName = "idVenta")
    @ManyToOne(optional = false)
    private Venta venta;

    public VentaLibro() {
    }

    public VentaLibro(Integer idVentaLibro) {
        this.idVentaLibro = idVentaLibro;
    }

    public Integer getIdVentaLibro() {
        return idVentaLibro;
    }

    public void setIdVentaLibro(Integer idVentaLibro) {
        this.idVentaLibro = idVentaLibro;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaLibro != null ? idVentaLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaLibro)) {
            return false;
        }
        VentaLibro other = (VentaLibro) object;
        if ((this.idVentaLibro == null && other.idVentaLibro != null) || (this.idVentaLibro != null && !this.idVentaLibro.equals(other.idVentaLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.VentaLibro[ idVentaLibro=" + idVentaLibro + " ]";
    }
    
}
