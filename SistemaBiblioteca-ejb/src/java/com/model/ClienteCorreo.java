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
@Table(name = "Cliente_Correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteCorreo.findAll", query = "SELECT c FROM ClienteCorreo c")
    , @NamedQuery(name = "ClienteCorreo.findByIdClienteCorreo", query = "SELECT c FROM ClienteCorreo c WHERE c.idClienteCorreo = :idClienteCorreo")})
public class ClienteCorreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClienteCorreo")
    private Integer idClienteCorreo;
    @JoinColumn(name = "cliente", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "correo", referencedColumnName = "idCorreo")
    @ManyToOne(optional = false)
    private Correo correo;

    public ClienteCorreo() {
    }

    public ClienteCorreo(Integer idClienteCorreo) {
        this.idClienteCorreo = idClienteCorreo;
    }

    public Integer getIdClienteCorreo() {
        return idClienteCorreo;
    }

    public void setIdClienteCorreo(Integer idClienteCorreo) {
        this.idClienteCorreo = idClienteCorreo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteCorreo != null ? idClienteCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteCorreo)) {
            return false;
        }
        ClienteCorreo other = (ClienteCorreo) object;
        if ((this.idClienteCorreo == null && other.idClienteCorreo != null) || (this.idClienteCorreo != null && !this.idClienteCorreo.equals(other.idClienteCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.ClienteCorreo[ idClienteCorreo=" + idClienteCorreo + " ]";
    }
    
}
