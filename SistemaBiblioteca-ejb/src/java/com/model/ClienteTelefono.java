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
@Table(name = "Cliente_Telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteTelefono.findAll", query = "SELECT c FROM ClienteTelefono c")
    , @NamedQuery(name = "ClienteTelefono.findByIdClienteTelefono", query = "SELECT c FROM ClienteTelefono c WHERE c.idClienteTelefono = :idClienteTelefono")})
public class ClienteTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClienteTelefono")
    private Integer idClienteTelefono;
    @JoinColumn(name = "cliente", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "telefono", referencedColumnName = "idTelefono")
    @ManyToOne(optional = false)
    private Telefono telefono;

    public ClienteTelefono() {
    }

    public ClienteTelefono(Integer idClienteTelefono) {
        this.idClienteTelefono = idClienteTelefono;
    }

    public Integer getIdClienteTelefono() {
        return idClienteTelefono;
    }

    public void setIdClienteTelefono(Integer idClienteTelefono) {
        this.idClienteTelefono = idClienteTelefono;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteTelefono != null ? idClienteTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteTelefono)) {
            return false;
        }
        ClienteTelefono other = (ClienteTelefono) object;
        if ((this.idClienteTelefono == null && other.idClienteTelefono != null) || (this.idClienteTelefono != null && !this.idClienteTelefono.equals(other.idClienteTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.ClienteTelefono[ idClienteTelefono=" + idClienteTelefono + " ]";
    }
    
}
