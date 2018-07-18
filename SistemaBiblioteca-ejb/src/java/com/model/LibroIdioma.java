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
@Table(name = "Libro_Idioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroIdioma.findAll", query = "SELECT l FROM LibroIdioma l")
    , @NamedQuery(name = "LibroIdioma.findByIdLibroIdioma", query = "SELECT l FROM LibroIdioma l WHERE l.idLibroIdioma = :idLibroIdioma")})
public class LibroIdioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLibroIdioma")
    private Integer idLibroIdioma;
    @JoinColumn(name = "idioma", referencedColumnName = "idIdioma")
    @ManyToOne(optional = false)
    private Idioma idioma;
    @JoinColumn(name = "libro", referencedColumnName = "numeroSerie")
    @ManyToOne(optional = false)
    private Libro libro;

    public LibroIdioma() {
    }

    public LibroIdioma(Integer idLibroIdioma) {
        this.idLibroIdioma = idLibroIdioma;
    }

    public Integer getIdLibroIdioma() {
        return idLibroIdioma;
    }

    public void setIdLibroIdioma(Integer idLibroIdioma) {
        this.idLibroIdioma = idLibroIdioma;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
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
        hash += (idLibroIdioma != null ? idLibroIdioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroIdioma)) {
            return false;
        }
        LibroIdioma other = (LibroIdioma) object;
        if ((this.idLibroIdioma == null && other.idLibroIdioma != null) || (this.idLibroIdioma != null && !this.idLibroIdioma.equals(other.idLibroIdioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.LibroIdioma[ idLibroIdioma=" + idLibroIdioma + " ]";
    }
    
}
