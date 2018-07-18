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
@Table(name = "Venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdVenta", query = "SELECT v FROM Venta v WHERE v.idVenta = :idVenta")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVenta")
    private Integer idVenta;
    @JoinColumn(name = "boleta", referencedColumnName = "idBoleta")
    @ManyToOne(optional = false)
    private Boleta boleta;
    @JoinColumn(name = "clienteInvolucrado", referencedColumnName = "rut")
    @ManyToOne
    private Cliente clienteInvolucrado;
    @JoinColumn(name = "trabajadorInvolucrado", referencedColumnName = "rut")
    @ManyToOne
    private Trabajador trabajadorInvolucrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<VentaLibro> ventaLibroList;

    public Venta() {
    }

    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    public Cliente getClienteInvolucrado() {
        return clienteInvolucrado;
    }

    public void setClienteInvolucrado(Cliente clienteInvolucrado) {
        this.clienteInvolucrado = clienteInvolucrado;
    }

    public Trabajador getTrabajadorInvolucrado() {
        return trabajadorInvolucrado;
    }

    public void setTrabajadorInvolucrado(Trabajador trabajadorInvolucrado) {
        this.trabajadorInvolucrado = trabajadorInvolucrado;
    }

    @XmlTransient
    public List<VentaLibro> getVentaLibroList() {
        return ventaLibroList;
    }

    public void setVentaLibroList(List<VentaLibro> ventaLibroList) {
        this.ventaLibroList = ventaLibroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Venta[ idVenta=" + idVenta + " ]";
    }
    
}
