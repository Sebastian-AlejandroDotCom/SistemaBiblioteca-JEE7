/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.TrabajadorTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface TrabajadorTelefonoFacadeLocal {

    void create(TrabajadorTelefono trabajadorTelefono);

    void edit(TrabajadorTelefono trabajadorTelefono);

    void remove(TrabajadorTelefono trabajadorTelefono);

    TrabajadorTelefono find(Object id);

    List<TrabajadorTelefono> findAll();

    List<TrabajadorTelefono> findRange(int[] range);

    int count();
    
}
