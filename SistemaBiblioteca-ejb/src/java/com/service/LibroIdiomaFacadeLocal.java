/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.LibroIdioma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface LibroIdiomaFacadeLocal {

    void create(LibroIdioma libroIdioma);

    void edit(LibroIdioma libroIdioma);

    void remove(LibroIdioma libroIdioma);

    LibroIdioma find(Object id);

    List<LibroIdioma> findAll();

    List<LibroIdioma> findRange(int[] range);

    int count();
    
}
