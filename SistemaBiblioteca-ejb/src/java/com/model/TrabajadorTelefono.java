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
@Table(name = "Trabajador_Telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabajadorTelefono.findAll", query = "SELECT t FROM TrabajadorTelefono t")
    , @NamedQuery(name = "TrabajadorTelefono.findByIdTrabajadorTelefono", query = "SELECT t FROM TrabajadorTelefono t WHERE t.idTrabajadorTelefono = :idTrabajadorTelefono")})
public class TrabajadorTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrabajadorTelefono")
    private Integer idTrabajadorTelefono;
    @JoinColumn(name = "telefono", referencedColumnName = "idTelefono")
    @ManyToOne(optional = false)
    private Telefono telefono;
    @JoinColumn(name = "trabajador", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Trabajador trabajador;

    public TrabajadorTelefono() {
    }

    public TrabajadorTelefono(Integer idTrabajadorTelefono) {
        this.idTrabajadorTelefono = idTrabajadorTelefono;
    }

    public Integer getIdTrabajadorTelefono() {
        return idTrabajadorTelefono;
    }

    public void setIdTrabajadorTelefono(Integer idTrabajadorTelefono) {
        this.idTrabajadorTelefono = idTrabajadorTelefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
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
        hash += (idTrabajadorTelefono != null ? idTrabajadorTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajadorTelefono)) {
            return false;
        }
        TrabajadorTelefono other = (TrabajadorTelefono) object;
        if ((this.idTrabajadorTelefono == null && other.idTrabajadorTelefono != null) || (this.idTrabajadorTelefono != null && !this.idTrabajadorTelefono.equals(other.idTrabajadorTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.TrabajadorTelefono[ idTrabajadorTelefono=" + idTrabajadorTelefono + " ]";
    }
    
}
