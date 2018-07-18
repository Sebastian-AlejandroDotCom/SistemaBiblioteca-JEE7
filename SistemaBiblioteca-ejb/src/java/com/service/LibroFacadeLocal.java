/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Libro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface LibroFacadeLocal {

    void create(Libro libro);

    void edit(Libro libro);

    void remove(Libro libro);

    Libro find(Object id);

    List<Libro> findAll();
    
    List<Libro> findByIsbn(String isbn);

    List<Libro> findRange(int[] range);

    int count();
    
}
