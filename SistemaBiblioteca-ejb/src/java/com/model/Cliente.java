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
@Table(name = "Cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByRut", query = "SELECT c FROM Cliente c WHERE c.rut = :rut")
    , @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Cliente.findByApellidoPaterno", query = "SELECT c FROM Cliente c WHERE c.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Cliente.findByApellidoMaterno", query = "SELECT c FROM Cliente c WHERE c.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Cliente.findByFechaNacimiento", query = "SELECT c FROM Cliente c WHERE c.fechaNacimiento = :fechaNacimiento")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rut")
    private Integer rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombreCliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @OneToMany(mappedBy = "clienteInvolucrado")
    private List<Venta> ventaList;
    @OneToMany(mappedBy = "clienteInvolucrado")
    private List<Arriendo> arriendoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<ClienteCorreo> clienteCorreoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<ClienteDireccion> clienteDireccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<ClienteTelefono> clienteTelefonoList;
    @OneToMany(mappedBy = "clienteInvolucrado")
    private List<Boleta> boletaList;

    public Cliente() {
    }

    public Cliente(Integer rut) {
        this.rut = rut;
    }

    public Cliente(Integer rut, String nombreCliente, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento) {
        this.rut = rut;
        this.nombreCliente = nombreCliente;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<Arriendo> getArriendoList() {
        return arriendoList;
    }

    public void setArriendoList(List<Arriendo> arriendoList) {
        this.arriendoList = arriendoList;
    }

    @XmlTransient
    public List<ClienteCorreo> getClienteCorreoList() {
        return clienteCorreoList;
    }

    public void setClienteCorreoList(List<ClienteCorreo> clienteCorreoList) {
        this.clienteCorreoList = clienteCorreoList;
    }

    @XmlTransient
    public List<ClienteDireccion> getClienteDireccionList() {
        return clienteDireccionList;
    }

    public void setClienteDireccionList(List<ClienteDireccion> clienteDireccionList) {
        this.clienteDireccionList = clienteDireccionList;
    }

    @XmlTransient
    public List<ClienteTelefono> getClienteTelefonoList() {
        return clienteTelefonoList;
    }

    public void setClienteTelefonoList(List<ClienteTelefono> clienteTelefonoList) {
        this.clienteTelefonoList = clienteTelefonoList;
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
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Cliente[ rut=" + rut + " ]";
    }
    
}
