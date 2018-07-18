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
@Table(name = "Libro_Autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroAutor.findAll", query = "SELECT l FROM LibroAutor l")
    , @NamedQuery(name = "LibroAutor.findByIdLibroAutor", query = "SELECT l FROM LibroAutor l WHERE l.idLibroAutor = :idLibroAutor")})
public class LibroAutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLibroAutor")
    private Integer idLibroAutor;
    @JoinColumn(name = "autor", referencedColumnName = "idAutor")
    @ManyToOne(optional = false)
    private Autor autor;
    @JoinColumn(name = "libro", referencedColumnName = "numeroSerie")
    @ManyToOne(optional = false)
    private Libro libro;

    public LibroAutor() {
    }

    public LibroAutor(Integer idLibroAutor) {
        this.idLibroAutor = idLibroAutor;
    }

    public Integer getIdLibroAutor() {
        return idLibroAutor;
    }

    public void setIdLibroAutor(Integer idLibroAutor) {
        this.idLibroAutor = idLibroAutor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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
        hash += (idLibroAutor != null ? idLibroAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroAutor)) {
            return false;
        }
        LibroAutor other = (LibroAutor) object;
        if ((this.idLibroAutor == null && other.idLibroAutor != null) || (this.idLibroAutor != null && !this.idLibroAutor.equals(other.idLibroAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.LibroAutor[ idLibroAutor=" + idLibroAutor + " ]";
    }
    
}
