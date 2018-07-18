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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "Estado_Libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoLibro.findAll", query = "SELECT e FROM EstadoLibro e")
    , @NamedQuery(name = "EstadoLibro.findByIdEstado", query = "SELECT e FROM EstadoLibro e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadoLibro.findByEstado", query = "SELECT e FROM EstadoLibro e WHERE e.estado = :estado")})
public class EstadoLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstado")
    private Integer idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "libro", referencedColumnName = "numeroSerie")
    @ManyToOne(optional = false)
    private Libro libro;

    public EstadoLibro() {
    }

    public EstadoLibro(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoLibro(Integer idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoLibro)) {
            return false;
        }
        EstadoLibro other = (EstadoLibro) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.EstadoLibro[ idEstado=" + idEstado + " ]";
    }
    
}
