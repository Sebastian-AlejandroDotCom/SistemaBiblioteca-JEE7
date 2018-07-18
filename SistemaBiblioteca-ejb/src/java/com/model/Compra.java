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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "Compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
    , @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompra")
    private Integer idCompra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private List<CompraLibro> compraLibroList;
    @JoinColumn(name = "distribuidorInvolucrado", referencedColumnName = "rut")
    @ManyToOne
    private Distribuidor distribuidorInvolucrado;
    @JoinColumn(name = "factura", referencedColumnName = "idFactura")
    @ManyToOne(optional = false)
    private Factura factura;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    @XmlTransient
    public List<CompraLibro> getCompraLibroList() {
        return compraLibroList;
    }

    public void setCompraLibroList(List<CompraLibro> compraLibroList) {
        this.compraLibroList = compraLibroList;
    }

    public Distribuidor getDistribuidorInvolucrado() {
        return distribuidorInvolucrado;
    }

    public void setDistribuidorInvolucrado(Distribuidor distribuidorInvolucrado) {
        this.distribuidorInvolucrado = distribuidorInvolucrado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Compra[ idCompra=" + idCompra + " ]";
    }
    
}
