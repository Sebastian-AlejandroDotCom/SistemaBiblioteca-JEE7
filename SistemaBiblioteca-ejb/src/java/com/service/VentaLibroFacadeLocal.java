/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.VentaLibro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface VentaLibroFacadeLocal {

    void create(VentaLibro ventaLibro);

    void edit(VentaLibro ventaLibro);

    void remove(VentaLibro ventaLibro);

    VentaLibro find(Object id);

    List<VentaLibro> findAll();

    List<VentaLibro> findRange(int[] range);

    int count();
    
}
