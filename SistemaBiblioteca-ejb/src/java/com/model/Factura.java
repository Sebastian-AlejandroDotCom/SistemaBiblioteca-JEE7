/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "Factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "Factura.findByFolio", query = "SELECT f FROM Factura f WHERE f.folio = :folio")
    , @NamedQuery(name = "Factura.findByPrecioNeto", query = "SELECT f FROM Factura f WHERE f.precioNeto = :precioNeto")
    , @NamedQuery(name = "Factura.findByPrecioConIva", query = "SELECT f FROM Factura f WHERE f.precioConIva = :precioConIva")
    , @NamedQuery(name = "Factura.findByCostoIva", query = "SELECT f FROM Factura f WHERE f.costoIva = :costoIva")
    , @NamedQuery(name = "Factura.findByFechaHoraCompra", query = "SELECT f FROM Factura f WHERE f.fechaHoraCompra = :fechaHoraCompra")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFactura")
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "folio")
    private String folio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioNeto")
    private int precioNeto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioConIva")
    private int precioConIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costoIva")
    private int costoIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHoraCompra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCompra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Compra> compraList;
    @JoinColumn(name = "distribuidorInvolucrado", referencedColumnName = "rut")
    @ManyToOne
    private Distribuidor distribuidorInvolucrado;
    @JoinColumn(name = "metodoPago", referencedColumnName = "idMetodoPago")
    @ManyToOne
    private MetodoPago metodoPago;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, String folio, int precioNeto, int precioConIva, int costoIva, Date fechaHoraCompra) {
        this.idFactura = idFactura;
        this.folio = folio;
        this.precioNeto = precioNeto;
        this.precioConIva = precioConIva;
        this.costoIva = costoIva;
        this.fechaHoraCompra = fechaHoraCompra;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getPrecioNeto() {
        return precioNeto;
    }

    public void setPrecioNeto(int precioNeto) {
        this.precioNeto = precioNeto;
    }

    public int getPrecioConIva() {
        return precioConIva;
    }

    public void setPrecioConIva(int precioConIva) {
        this.precioConIva = precioConIva;
    }

    public int getCostoIva() {
        return costoIva;
    }

    public void setCostoIva(int costoIva) {
        this.costoIva = costoIva;
    }

    public Date getFechaHoraCompra() {
        return fechaHoraCompra;
    }

    public void setFechaHoraCompra(Date fechaHoraCompra) {
        this.fechaHoraCompra = fechaHoraCompra;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public Distribuidor getDistribuidorInvolucrado() {
        return distribuidorInvolucrado;
    }

    public void setDistribuidorInvolucrado(Distribuidor distribuidorInvolucrado) {
        this.distribuidorInvolucrado = distribuidorInvolucrado;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
