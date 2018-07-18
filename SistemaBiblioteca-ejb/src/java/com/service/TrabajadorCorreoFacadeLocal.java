/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.TrabajadorCorreo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface TrabajadorCorreoFacadeLocal {

    void create(TrabajadorCorreo trabajadorCorreo);

    void edit(TrabajadorCorreo trabajadorCorreo);

    void remove(TrabajadorCorreo trabajadorCorreo);

    TrabajadorCorreo find(Object id);

    List<TrabajadorCorreo> findAll();

    List<TrabajadorCorreo> findRange(int[] range);

    int count();
    
}
