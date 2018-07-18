/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.LibroCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface LibroCategoriaFacadeLocal {

    void create(LibroCategoria libroCategoria);

    void edit(LibroCategoria libroCategoria);

    void remove(LibroCategoria libroCategoria);

    LibroCategoria find(Object id);

    List<LibroCategoria> findAll();

    List<LibroCategoria> findRange(int[] range);

    int count();
    
}
