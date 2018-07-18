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
@Table(name = "Correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correo.findAll", query = "SELECT c FROM Correo c")
    , @NamedQuery(name = "Correo.findByIdCorreo", query = "SELECT c FROM Correo c WHERE c.idCorreo = :idCorreo")
    , @NamedQuery(name = "Correo.findByDetalleCorreo", query = "SELECT c FROM Correo c WHERE c.detalleCorreo = :detalleCorreo")})
public class Correo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCorreo")
    private Integer idCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "detalleCorreo")
    private String detalleCorreo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correo")
    private List<ClienteCorreo> clienteCorreoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correo")
    private List<TrabajadorCorreo> trabajadorCorreoList;

    public Correo() {
    }

    public Correo(Integer idCorreo) {
        this.idCorreo = idCorreo;
    }

    public Correo(Integer idCorreo, String detalleCorreo) {
        this.idCorreo = idCorreo;
        this.detalleCorreo = detalleCorreo;
    }

    public Integer getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(Integer idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getDetalleCorreo() {
        return detalleCorreo;
    }

    public void setDetalleCorreo(String detalleCorreo) {
        this.detalleCorreo = detalleCorreo;
    }

    @XmlTransient
    public List<ClienteCorreo> getClienteCorreoList() {
        return clienteCorreoList;
    }

    public void setClienteCorreoList(List<ClienteCorreo> clienteCorreoList) {
        this.clienteCorreoList = clienteCorreoList;
    }

    @XmlTransient
    public List<TrabajadorCorreo> getTrabajadorCorreoList() {
        return trabajadorCorreoList;
    }

    public void setTrabajadorCorreoList(List<TrabajadorCorreo> trabajadorCorreoList) {
        this.trabajadorCorreoList = trabajadorCorreoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorreo != null ? idCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correo)) {
            return false;
        }
        Correo other = (Correo) object;
        if ((this.idCorreo == null && other.idCorreo != null) || (this.idCorreo != null && !this.idCorreo.equals(other.idCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Correo[ idCorreo=" + idCorreo + " ]";
    }
    
}
