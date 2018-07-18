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
@Table(name = "Compra_Libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraLibro.findAll", query = "SELECT c FROM CompraLibro c")
    , @NamedQuery(name = "CompraLibro.findByIdCompraLibro", query = "SELECT c FROM CompraLibro c WHERE c.idCompraLibro = :idCompraLibro")})
public class CompraLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompraLibro")
    private Integer idCompraLibro;
    @JoinColumn(name = "compra", referencedColumnName = "idCompra")
    @ManyToOne(optional = false)
    private Compra compra;
    @JoinColumn(name = "libro", referencedColumnName = "numeroSerie")
    @ManyToOne(optional = false)
    private Libro libro;

    public CompraLibro() {
    }

    public CompraLibro(Integer idCompraLibro) {
        this.idCompraLibro = idCompraLibro;
    }

    public Integer getIdCompraLibro() {
        return idCompraLibro;
    }

    public void setIdCompraLibro(Integer idCompraLibro) {
        this.idCompraLibro = idCompraLibro;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompraLibro != null ? idCompraLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraLibro)) {
            return false;
        }
        CompraLibro other = (CompraLibro) object;
        if ((this.idCompraLibro == null && other.idCompraLibro != null) || (this.idCompraLibro != null && !this.idCompraLibro.equals(other.idCompraLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.CompraLibro[ idCompraLibro=" + idCompraLibro + " ]";
    }
    
}
