/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Autor;
import com.model.Categoria;
import com.model.Editorial;
import com.model.Idioma;
import com.model.Libro;
import com.model.LibroAutor;
import com.model.LibroCategoria;
import com.model.LibroIdioma;
import com.service.AutorFacadeLocal;
import com.service.CategoriaFacadeLocal;
import com.service.EditorialFacadeLocal;
import com.service.IdiomaFacadeLocal;
import com.service.LibroAutorFacadeLocal;
import com.service.LibroCategoriaFacadeLocal;
import com.service.LibroFacadeLocal;
import com.service.LibroIdiomaFacadeLocal;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sebastian
 */
@WebServlet(name = "EditarLibroServlet", urlPatterns = {"/editarLibro"})
public class EditarLibroServlet extends HttpServlet {

    @EJB
    private LibroCategoriaFacadeLocal libroCategoriaFacade;

    @EJB
    private LibroIdiomaFacadeLocal libroIdiomaFacade;

    @EJB
    private LibroAutorFacadeLocal libroAutorFacade;

    @EJB
    private LibroFacadeLocal libroFacade;

    @EJB
    private EditorialFacadeLocal editorialFacade;

    @EJB
    private CategoriaFacadeLocal categoriaFacade;

    @EJB
    private IdiomaFacadeLocal idiomaFacade;

    @EJB
    private AutorFacadeLocal autorFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nSerie = request.getParameter("editNumeroSerie");

        Libro libro = libroFacade.find(Integer.parseInt(nSerie));

        request.setAttribute("listaAutores", autorFacade.findAll());
        request.setAttribute("listaIdiomas", idiomaFacade.findAll());
        request.setAttribute("listaCategorias", categoriaFacade.findAll());
        request.setAttribute("listaEditoriales", editorialFacade.findAll());

        request.setAttribute("libro", libro);
        request.getRequestDispatcher("/editarLibro.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String numeroSerie = request.getParameter("numeroSerie");
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String[] idAutor = request.getParameterValues("autor");
        String paginas = request.getParameter("paginas");
        String precio = request.getParameter("precio");
        String[] idIdioma = request.getParameterValues("idioma");
        String[] idCategoria = request.getParameterValues("categoria");
        String añoStr = request.getParameter("anno");
        String publicacionStr = request.getParameter("publicacion");
        String idEditorial = request.getParameter("editorial");

        Editorial editorial = editorialFacade.find(Integer.parseInt(idEditorial));

        Date año = null;
        Date publicacion = null;
        try {
            año = format.parse(añoStr);
            publicacion = format.parse(publicacionStr);
        } catch (ParseException ex) {
            Logger.getLogger(RegistroLibroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        Libro libro = libroFacade.find(Integer.parseInt(numeroSerie));
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setPaginas(Integer.parseInt(paginas));
        libro.setPrecio(Integer.parseInt(precio));
        libro.setAño(año);
        libro.setPublicacion(publicacion);
        libro.setEditorial(editorial);
        libroFacade.edit(libro);

        for (LibroAutor libroAutor : libro.getLibroAutorList()) {
            libroAutorFacade.remove(libroAutor);
        }
        libro.getLibroAutorList().clear();
        for (String var : idAutor) {
            Autor autor = autorFacade.find(Integer.parseInt(var));

            LibroAutor libroAutor = new LibroAutor();
            libroAutor.setLibro(libro);
            libroAutor.setAutor(autor);
            libroAutorFacade.create(libroAutor);
            libro.getLibroAutorList().add(libroAutor);
            autor.getLibroAutorList().add(libroAutor);
        }
        for (LibroIdioma libroIdioma : libro.getLibroIdiomaList()){
            libroIdiomaFacade.remove(libroIdioma);
        }
        libro.getLibroIdiomaList().clear();
        for (String var : idIdioma) {
            Idioma idioma = idiomaFacade.find(Integer.parseInt(var));

            LibroIdioma libroIdioma = new LibroIdioma();
            libroIdioma.setLibro(libro);
            libroIdioma.setIdioma(idioma);
            libroIdiomaFacade.create(libroIdioma);
            libro.getLibroIdiomaList().add(libroIdioma);
            idioma.getLibroIdiomaList().add(libroIdioma);
        }
        for (LibroCategoria libroCategoria : libro.getLibroCategoriaList()){
            libroCategoriaFacade.remove(libroCategoria);
        }
        libro.getLibroCategoriaList().clear();
        for (String var : idCategoria) {
            Categoria categoria = categoriaFacade.find(Integer.parseInt(var));

            LibroCategoria libroCategoria = new LibroCategoria();
            libroCategoria.setLibro(libro);
            libroCategoria.setCategoria(categoria);
            libroCategoriaFacade.create(libroCategoria);
            libro.getLibroCategoriaList().add(libroCategoria);
            categoria.getLibroCategoriaList().add(libroCategoria);
        }

        libroFacade.edit(libro);

        request.setAttribute("libros", libroFacade.findAll());
        request.getRequestDispatcher("/libro.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
