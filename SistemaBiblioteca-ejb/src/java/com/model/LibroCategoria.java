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
@Table(name = "Libro_Categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroCategoria.findAll", query = "SELECT l FROM LibroCategoria l")
    , @NamedQuery(name = "LibroCategoria.findByIdLibroCategoria", query = "SELECT l FROM LibroCategoria l WHERE l.idLibroCategoria = :idLibroCategoria")})
public class LibroCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLibroCategoria")
    private Integer idLibroCategoria;
    @JoinColumn(name = "categoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "libro", referencedColumnName = "numeroSerie")
    @ManyToOne(optional = false)
    private Libro libro;

    public LibroCategoria() {
    }

    public LibroCategoria(Integer idLibroCategoria) {
        this.idLibroCategoria = idLibroCategoria;
    }

    public Integer getIdLibroCategoria() {
        return idLibroCategoria;
    }

    public void setIdLibroCategoria(Integer idLibroCategoria) {
        this.idLibroCategoria = idLibroCategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        hash += (idLibroCategoria != null ? idLibroCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroCategoria)) {
            return false;
        }
        LibroCategoria other = (LibroCategoria) object;
        if ((this.idLibroCategoria == null && other.idLibroCategoria != null) || (this.idLibroCategoria != null && !this.idLibroCategoria.equals(other.idLibroCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.LibroCategoria[ idLibroCategoria=" + idLibroCategoria + " ]";
    }
    
}
