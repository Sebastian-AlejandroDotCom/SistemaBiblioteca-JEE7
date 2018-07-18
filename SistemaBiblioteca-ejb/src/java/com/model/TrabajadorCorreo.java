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
@Table(name = "Trabajador_Correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabajadorCorreo.findAll", query = "SELECT t FROM TrabajadorCorreo t")
    , @NamedQuery(name = "TrabajadorCorreo.findByIdTrabajadorCorreo", query = "SELECT t FROM TrabajadorCorreo t WHERE t.idTrabajadorCorreo = :idTrabajadorCorreo")})
public class TrabajadorCorreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrabajadorCorreo")
    private Integer idTrabajadorCorreo;
    @JoinColumn(name = "correo", referencedColumnName = "idCorreo")
    @ManyToOne(optional = false)
    private Correo correo;
    @JoinColumn(name = "trabajador", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Trabajador trabajador;

    public TrabajadorCorreo() {
    }

    public TrabajadorCorreo(Integer idTrabajadorCorreo) {
        this.idTrabajadorCorreo = idTrabajadorCorreo;
    }

    public Integer getIdTrabajadorCorreo() {
        return idTrabajadorCorreo;
    }

    public void setIdTrabajadorCorreo(Integer idTrabajadorCorreo) {
        this.idTrabajadorCorreo = idTrabajadorCorreo;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
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
        hash += (idTrabajadorCorreo != null ? idTrabajadorCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajadorCorreo)) {
            return false;
        }
        TrabajadorCorreo other = (TrabajadorCorreo) object;
        if ((this.idTrabajadorCorreo == null && other.idTrabajadorCorreo != null) || (this.idTrabajadorCorreo != null && !this.idTrabajadorCorreo.equals(other.idTrabajadorCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.TrabajadorCorreo[ idTrabajadorCorreo=" + idTrabajadorCorreo + " ]";
    }
    
}
