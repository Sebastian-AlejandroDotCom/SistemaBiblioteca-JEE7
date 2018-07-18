/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "Metodo_Pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetodoPago.findAll", query = "SELECT m FROM MetodoPago m")
    , @NamedQuery(name = "MetodoPago.findByIdMetodoPago", query = "SELECT m FROM MetodoPago m WHERE m.idMetodoPago = :idMetodoPago")
    , @NamedQuery(name = "MetodoPago.findByDetalleMetodoPago", query = "SELECT m FROM MetodoPago m WHERE m.detalleMetodoPago = :detalleMetodoPago")})
public class MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMetodoPago")
    private Integer idMetodoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "detalleMetodoPago")
    private String detalleMetodoPago;
    @OneToMany(mappedBy = "metodoPago")
    private List<Factura> facturaList;
    @OneToMany(mappedBy = "metodoPago")
    private List<Boleta> boletaList;

    public MetodoPago() {
    }

    public MetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public MetodoPago(Integer idMetodoPago, String detalleMetodoPago) {
        this.idMetodoPago = idMetodoPago;
        this.detalleMetodoPago = detalleMetodoPago;
    }

    public Integer getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getDetalleMetodoPago() {
        return detalleMetodoPago;
    }

    public void setDetalleMetodoPago(String detalleMetodoPago) {
        this.detalleMetodoPago = detalleMetodoPago;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<Boleta> getBoletaList() {
        return boletaList;
    }

    public void setBoletaList(List<Boleta> boletaList) {
        this.boletaList = boletaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMetodoPago != null ? idMetodoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetodoPago)) {
            return false;
        }
        MetodoPago other = (MetodoPago) object;
        if ((this.idMetodoPago == null && other.idMetodoPago != null) || (this.idMetodoPago != null && !this.idMetodoPago.equals(other.idMetodoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.MetodoPago[ idMetodoPago=" + idMetodoPago + " ]";
    }
    
}
