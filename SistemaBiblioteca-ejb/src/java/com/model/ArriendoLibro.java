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
@Table(name = "Arriendo_Libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArriendoLibro.findAll", query = "SELECT a FROM ArriendoLibro a")
    , @NamedQuery(name = "ArriendoLibro.findByIdArriendoLibro", query = "SELECT a FROM ArriendoLibro a WHERE a.idArriendoLibro = :idArriendoLibro")})
public class ArriendoLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArriendoLibro")
    private Integer idArriendoLibro;
    @JoinColumn(name = "arriendo", referencedColumnName = "idArriendo")
    @ManyToOne(optional = false)
    private Arriendo arriendo;
    @JoinColumn(name = "libro", referencedColumnName = "numeroSerie")
    @ManyToOne(optional = false)
    private Libro libro;

    public ArriendoLibro() {
    }

    public ArriendoLibro(Integer idArriendoLibro) {
        this.idArriendoLibro = idArriendoLibro;
    }

    public Integer getIdArriendoLibro() {
        return idArriendoLibro;
    }

    public void setIdArriendoLibro(Integer idArriendoLibro) {
        this.idArriendoLibro = idArriendoLibro;
    }

    public Arriendo getArriendo() {
        return arriendo;
    }

    public void setArriendo(Arriendo arriendo) {
        this.arriendo = arriendo;
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
        hash += (idArriendoLibro != null ? idArriendoLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArriendoLibro)) {
            return false;
        }
        ArriendoLibro other = (ArriendoLibro) object;
        if ((this.idArriendoLibro == null && other.idArriendoLibro != null) || (this.idArriendoLibro != null && !this.idArriendoLibro.equals(other.idArriendoLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.ArriendoLibro[ idArriendoLibro=" + idArriendoLibro + " ]";
    }
    
}
