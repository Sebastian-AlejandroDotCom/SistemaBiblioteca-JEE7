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
@Table(name = "Arriendo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arriendo.findAll", query = "SELECT a FROM Arriendo a")
    , @NamedQuery(name = "Arriendo.findByIdArriendo", query = "SELECT a FROM Arriendo a WHERE a.idArriendo = :idArriendo")
    , @NamedQuery(name = "Arriendo.findByCostoTotal", query = "SELECT a FROM Arriendo a WHERE a.costoTotal = :costoTotal")
    , @NamedQuery(name = "Arriendo.findByFechaArriendo", query = "SELECT a FROM Arriendo a WHERE a.fechaArriendo = :fechaArriendo")
    , @NamedQuery(name = "Arriendo.findByFechaDevolucion", query = "SELECT a FROM Arriendo a WHERE a.fechaDevolucion = :fechaDevolucion")
    , @NamedQuery(name = "Arriendo.findByFechaEntrega", query = "SELECT a FROM Arriendo a WHERE a.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Arriendo.findByDiasRetraso", query = "SELECT a FROM Arriendo a WHERE a.diasRetraso = :diasRetraso")
    , @NamedQuery(name = "Arriendo.findByMulta", query = "SELECT a FROM Arriendo a WHERE a.multa = :multa")
    , @NamedQuery(name = "Arriendo.findByCostoArriendo", query = "SELECT a FROM Arriendo a WHERE a.costoArriendo = :costoArriendo")})
public class Arriendo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArriendo")
    private Integer idArriendo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costoTotal")
    private int costoTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaArriendo")
    @Temporal(TemporalType.DATE)
    private Date fechaArriendo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDevolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diasRetraso")
    private int diasRetraso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "multa")
    private int multa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costoArriendo")
    private int costoArriendo;
    @JoinColumn(name = "clienteInvolucrado", referencedColumnName = "rut")
    @ManyToOne
    private Cliente clienteInvolucrado;
    @JoinColumn(name = "trabajadorInvolucrado", referencedColumnName = "rut")
    @ManyToOne
    private Trabajador trabajadorInvolucrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arriendo")
    private List<ArriendoLibro> arriendoLibroList;

    public Arriendo() {
    }

    public Arriendo(Integer idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Arriendo(Integer idArriendo, int costoTotal, Date fechaArriendo, Date fechaDevolucion, Date fechaEntrega, int diasRetraso, int multa, int costoArriendo) {
        this.idArriendo = idArriendo;
        this.costoTotal = costoTotal;
        this.fechaArriendo = fechaArriendo;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaEntrega = fechaEntrega;
        this.diasRetraso = diasRetraso;
        this.multa = multa;
        this.costoArriendo = costoArriendo;
    }

    public Integer getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(Integer idArriendo) {
        this.idArriendo = idArriendo;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Date fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getDiasRetraso() {
        return diasRetraso;
    }

    public void setDiasRetraso(int diasRetraso) {
        this.diasRetraso = diasRetraso;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public int getCostoArriendo() {
        return costoArriendo;
    }

    public void setCostoArriendo(int costoArriendo) {
        this.costoArriendo = costoArriendo;
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
    public List<ArriendoLibro> getArriendoLibroList() {
        return arriendoLibroList;
    }

    public void setArriendoLibroList(List<ArriendoLibro> arriendoLibroList) {
        this.arriendoLibroList = arriendoLibroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArriendo != null ? idArriendo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arriendo)) {
            return false;
        }
        Arriendo other = (Arriendo) object;
        if ((this.idArriendo == null && other.idArriendo != null) || (this.idArriendo != null && !this.idArriendo.equals(other.idArriendo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Arriendo[ idArriendo=" + idArriendo + " ]";
    }
    
}
