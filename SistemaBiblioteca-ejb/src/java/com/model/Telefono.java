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
@Table(name = "Telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t")
    , @NamedQuery(name = "Telefono.findByIdTelefono", query = "SELECT t FROM Telefono t WHERE t.idTelefono = :idTelefono")
    , @NamedQuery(name = "Telefono.findByDetalleTelefono", query = "SELECT t FROM Telefono t WHERE t.detalleTelefono = :detalleTelefono")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTelefono")
    private Integer idTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "detalleTelefono")
    private String detalleTelefono;
    @OneToMany(mappedBy = "telefono")
    private List<Distribuidor> distribuidorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telefono")
    private List<TrabajadorTelefono> trabajadorTelefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telefono")
    private List<ClienteTelefono> clienteTelefonoList;

    public Telefono() {
    }

    public Telefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public Telefono(Integer idTelefono, String detalleTelefono) {
        this.idTelefono = idTelefono;
        this.detalleTelefono = detalleTelefono;
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getDetalleTelefono() {
        return detalleTelefono;
    }

    public void setDetalleTelefono(String detalleTelefono) {
        this.detalleTelefono = detalleTelefono;
    }

    @XmlTransient
    public List<Distribuidor> getDistribuidorList() {
        return distribuidorList;
    }

    public void setDistribuidorList(List<Distribuidor> distribuidorList) {
        this.distribuidorList = distribuidorList;
    }

    @XmlTransient
    public List<TrabajadorTelefono> getTrabajadorTelefonoList() {
        return trabajadorTelefonoList;
    }

    public void setTrabajadorTelefonoList(List<TrabajadorTelefono> trabajadorTelefonoList) {
        this.trabajadorTelefonoList = trabajadorTelefonoList;
    }

    @XmlTransient
    public List<ClienteTelefono> getClienteTelefonoList() {
        return clienteTelefonoList;
    }

    public void setClienteTelefonoList(List<ClienteTelefono> clienteTelefonoList) {
        this.clienteTelefonoList = clienteTelefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefono != null ? idTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.idTelefono == null && other.idTelefono != null) || (this.idTelefono != null && !this.idTelefono.equals(other.idTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Telefono[ idTelefono=" + idTelefono + " ]";
    }
    
}
