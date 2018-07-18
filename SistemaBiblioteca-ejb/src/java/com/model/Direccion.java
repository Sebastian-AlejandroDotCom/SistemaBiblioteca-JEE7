/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "Direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
    , @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT d FROM Direccion d WHERE d.idDireccion = :idDireccion")
    , @NamedQuery(name = "Direccion.findByDetalleDireccion", query = "SELECT d FROM Direccion d WHERE d.detalleDireccion = :detalleDireccion")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccion")
    private Integer idDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "detalleDireccion")
    private String detalleDireccion;
    @OneToMany(mappedBy = "direccion")
    private List<Distribuidor> distribuidorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccion")
    private List<ClienteDireccion> clienteDireccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccion")
    private List<TrabajadorDireccion> trabajadorDireccionList;

    public Direccion() {
    }

    public Direccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Direccion(Integer idDireccion, String detalleDireccion) {
        this.idDireccion = idDireccion;
        this.detalleDireccion = detalleDireccion;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getDetalleDireccion() {
        return detalleDireccion;
    }

    public void setDetalleDireccion(String detalleDireccion) {
        this.detalleDireccion = detalleDireccion;
    }

    @XmlTransient
    public List<Distribuidor> getDistribuidorList() {
        return distribuidorList;
    }

    public void setDistribuidorList(List<Distribuidor> distribuidorList) {
        this.distribuidorList = distribuidorList;
    }

    @XmlTransient
    public List<ClienteDireccion> getClienteDireccionList() {
        return clienteDireccionList;
    }

    public void setClienteDireccionList(List<ClienteDireccion> clienteDireccionList) {
        this.clienteDireccionList = clienteDireccionList;
    }

    @XmlTransient
    public List<TrabajadorDireccion> getTrabajadorDireccionList() {
        return trabajadorDireccionList;
    }

    public void setTrabajadorDireccionList(List<TrabajadorDireccion> trabajadorDireccionList) {
        this.trabajadorDireccionList = trabajadorDireccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Direccion[ idDireccion=" + idDireccion + " ]";
    }
    
}
