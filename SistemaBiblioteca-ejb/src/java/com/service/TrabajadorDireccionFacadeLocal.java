/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.TrabajadorDireccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface TrabajadorDireccionFacadeLocal {

    void create(TrabajadorDireccion trabajadorDireccion);

    void edit(TrabajadorDireccion trabajadorDireccion);

    void remove(TrabajadorDireccion trabajadorDireccion);

    TrabajadorDireccion find(Object id);

    List<TrabajadorDireccion> findAll();

    List<TrabajadorDireccion> findRange(int[] range);

    int count();
    
}
