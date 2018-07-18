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
@Table(name = "Cliente_Direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteDireccion.findAll", query = "SELECT c FROM ClienteDireccion c")
    , @NamedQuery(name = "ClienteDireccion.findByIdClienteDireccion", query = "SELECT c FROM ClienteDireccion c WHERE c.idClienteDireccion = :idClienteDireccion")})
public class ClienteDireccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClienteDireccion")
    private Integer idClienteDireccion;
    @JoinColumn(name = "cliente", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "direccion", referencedColumnName = "idDireccion")
    @ManyToOne(optional = false)
    private Direccion direccion;

    public ClienteDireccion() {
    }

    public ClienteDireccion(Integer idClienteDireccion) {
        this.idClienteDireccion = idClienteDireccion;
    }

    public Integer getIdClienteDireccion() {
        return idClienteDireccion;
    }

    public void setIdClienteDireccion(Integer idClienteDireccion) {
        this.idClienteDireccion = idClienteDireccion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteDireccion != null ? idClienteDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteDireccion)) {
            return false;
        }
        ClienteDireccion other = (ClienteDireccion) object;
        if ((this.idClienteDireccion == null && other.idClienteDireccion != null) || (this.idClienteDireccion != null && !this.idClienteDireccion.equals(other.idClienteDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.ClienteDireccion[ idClienteDireccion=" + idClienteDireccion + " ]";
    }
    
}
