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
@Table(name = "Trabajador_Direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabajadorDireccion.findAll", query = "SELECT t FROM TrabajadorDireccion t")
    , @NamedQuery(name = "TrabajadorDireccion.findByIdTrabajadorDireccion", query = "SELECT t FROM TrabajadorDireccion t WHERE t.idTrabajadorDireccion = :idTrabajadorDireccion")})
public class TrabajadorDireccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrabajadorDireccion")
    private Integer idTrabajadorDireccion;
    @JoinColumn(name = "direccion", referencedColumnName = "idDireccion")
    @ManyToOne(optional = false)
    private Direccion direccion;
    @JoinColumn(name = "trabajador", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Trabajador trabajador;

    public TrabajadorDireccion() {
    }

    public TrabajadorDireccion(Integer idTrabajadorDireccion) {
        this.idTrabajadorDireccion = idTrabajadorDireccion;
    }

    public Integer getIdTrabajadorDireccion() {
        return idTrabajadorDireccion;
    }

    public void setIdTrabajadorDireccion(Integer idTrabajadorDireccion) {
        this.idTrabajadorDireccion = idTrabajadorDireccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajadorDireccion != null ? idTrabajadorDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajadorDireccion)) {
            return false;
        }
        TrabajadorDireccion other = (TrabajadorDireccion) object;
        if ((this.idTrabajadorDireccion == null && other.idTrabajadorDireccion != null) || (this.idTrabajadorDireccion != null && !this.idTrabajadorDireccion.equals(other.idTrabajadorDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.TrabajadorDireccion[ idTrabajadorDireccion=" + idTrabajadorDireccion + " ]";
    }
    
}
