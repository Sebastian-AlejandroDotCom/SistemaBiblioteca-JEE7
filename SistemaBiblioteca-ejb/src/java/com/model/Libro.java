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
@Table(name = "Libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByNumeroSerie", query = "SELECT l FROM Libro l WHERE l.numeroSerie = :numeroSerie")
    , @NamedQuery(name = "Libro.findByIsbn", query = "SELECT l FROM Libro l WHERE l.isbn = :isbn")
    , @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Libro.findByPaginas", query = "SELECT l FROM Libro l WHERE l.paginas = :paginas")
    , @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio")
    , @NamedQuery(name = "Libro.findByStock", query = "SELECT l FROM Libro l WHERE l.stock = :stock")
    , @NamedQuery(name = "Libro.findByA\u00f1o", query = "SELECT l FROM Libro l WHERE l.a\u00f1o = :a\u00f1o")
    , @NamedQuery(name = "Libro.findByPublicacion", query = "SELECT l FROM Libro l WHERE l.publicacion = :publicacion")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeroSerie")
    private Integer numeroSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paginas")
    private int paginas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a\u00f1o")
    @Temporal(TemporalType.DATE)
    private Date año;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publicacion")
    @Temporal(TemporalType.DATE)
    private Date publicacion;
    @JoinColumn(name = "editorial", referencedColumnName = "idEditorial")
    @ManyToOne
    private Editorial editorial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private List<LibroIdioma> libroIdiomaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private List<LibroAutor> libroAutorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private List<CompraLibro> compraLibroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private List<ArriendoLibro> arriendoLibroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private List<LibroCategoria> libroCategoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private List<EstadoLibro> estadoLibroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private List<VentaLibro> ventaLibroList;

    public Libro() {
    }

    public Libro(Integer numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Libro(Integer numeroSerie, String isbn, String titulo, int paginas, int precio, int stock, Date año, Date publicacion) {
        this.numeroSerie = numeroSerie;
        this.isbn = isbn;
        this.titulo = titulo;
        this.paginas = paginas;
        this.precio = precio;
        this.stock = stock;
        this.año = año;
        this.publicacion = publicacion;
    }

    public Integer getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(Integer numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getAño() {
        return año;
    }

    public void setAño(Date año) {
        this.año = año;
    }

    public Date getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Date publicacion) {
        this.publicacion = publicacion;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @XmlTransient
    public List<LibroIdioma> getLibroIdiomaList() {
        return libroIdiomaList;
    }

    public void setLibroIdiomaList(List<LibroIdioma> libroIdiomaList) {
        this.libroIdiomaList = libroIdiomaList;
    }

    @XmlTransient
    public List<LibroAutor> getLibroAutorList() {
        return libroAutorList;
    }

    public void setLibroAutorList(List<LibroAutor> libroAutorList) {
        this.libroAutorList = libroAutorList;
    }

    @XmlTransient
    public List<CompraLibro> getCompraLibroList() {
        return compraLibroList;
    }

    public void setCompraLibroList(List<CompraLibro> compraLibroList) {
        this.compraLibroList = compraLibroList;
    }

    @XmlTransient
    public List<ArriendoLibro> getArriendoLibroList() {
        return arriendoLibroList;
    }

    public void setArriendoLibroList(List<ArriendoLibro> arriendoLibroList) {
        this.arriendoLibroList = arriendoLibroList;
    }

    @XmlTransient
    public List<LibroCategoria> getLibroCategoriaList() {
        return libroCategoriaList;
    }

    public void setLibroCategoriaList(List<LibroCategoria> libroCategoriaList) {
        this.libroCategoriaList = libroCategoriaList;
    }

    @XmlTransient
    public List<EstadoLibro> getEstadoLibroList() {
        return estadoLibroList;
    }

    public void setEstadoLibroList(List<EstadoLibro> estadoLibroList) {
        this.estadoLibroList = estadoLibroList;
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
        hash += (numeroSerie != null ? numeroSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.numeroSerie == null && other.numeroSerie != null) || (this.numeroSerie != null && !this.numeroSerie.equals(other.numeroSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Libro[ numeroSerie=" + numeroSerie + " ]";
    }

}
