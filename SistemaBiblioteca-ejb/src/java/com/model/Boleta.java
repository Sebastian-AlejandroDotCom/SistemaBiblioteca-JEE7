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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "Boleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b")
    , @NamedQuery(name = "Boleta.findByIdBoleta", query = "SELECT b FROM Boleta b WHERE b.idBoleta = :idBoleta")
    , @NamedQuery(name = "Boleta.findByFolio", query = "SELECT b FROM Boleta b WHERE b.folio = :folio")
    , @NamedQuery(name = "Boleta.findByPrecioNeto", query = "SELECT b FROM Boleta b WHERE b.precioNeto = :precioNeto")
    , @NamedQuery(name = "Boleta.findByPrecioConIva", query = "SELECT b FROM Boleta b WHERE b.precioConIva = :precioConIva")
    , @NamedQuery(name = "Boleta.findByCostoIva", query = "SELECT b FROM Boleta b WHERE b.costoIva = :costoIva")
    , @NamedQuery(name = "Boleta.findByFechaHoraVenta", query = "SELECT b FROM Boleta b WHERE b.fechaHoraVenta = :fechaHoraVenta")})
public class Boleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBoleta")
    private Integer idBoleta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "folio")
    private int folio;
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
    @Column(name = "fechaHoraVenta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boleta")
    private List<Venta> ventaList;
    @JoinColumn(name = "clienteInvolucrado", referencedColumnName = "rut")
    @ManyToOne
    private Cliente clienteInvolucrado;
    @JoinColumn(name = "metodoPago", referencedColumnName = "idMetodoPago")
    @ManyToOne
    private MetodoPago metodoPago;
    @JoinColumn(name = "trabajadorInvolucrado", referencedColumnName = "rut")
    @ManyToOne
    private Trabajador trabajadorInvolucrado;

    public Boleta() {
    }

    public Boleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public Boleta(Integer idBoleta, int folio, int precioNeto, int precioConIva, int costoIva, Date fechaHoraVenta) {
        this.idBoleta = idBoleta;
        this.folio = folio;
        this.precioNeto = precioNeto;
        this.precioConIva = precioConIva;
        this.costoIva = costoIva;
        this.fechaHoraVenta = fechaHoraVenta;
    }

    public Integer getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(Integer idBoleta) {
        this.idBoleta = idBoleta;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
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

    public Date getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    public void setFechaHoraVenta(Date fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Cliente getClienteInvolucrado() {
        return clienteInvolucrado;
    }

    public void setClienteInvolucrado(Cliente clienteInvolucrado) {
        this.clienteInvolucrado = clienteInvolucrado;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Trabajador getTrabajadorInvolucrado() {
        return trabajadorInvolucrado;
    }

    public void setTrabajadorInvolucrado(Trabajador trabajadorInvolucrado) {
        this.trabajadorInvolucrado = trabajadorInvolucrado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoleta != null ? idBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.idBoleta == null && other.idBoleta != null) || (this.idBoleta != null && !this.idBoleta.equals(other.idBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Boleta[ idBoleta=" + idBoleta + " ]";
    }
    
}
