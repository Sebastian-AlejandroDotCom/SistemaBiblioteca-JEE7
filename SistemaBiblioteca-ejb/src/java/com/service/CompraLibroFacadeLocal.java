/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.CompraLibro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface CompraLibroFacadeLocal {

    void create(CompraLibro compraLibro);

    void edit(CompraLibro compraLibro);

    void remove(CompraLibro compraLibro);

    CompraLibro find(Object id);

    List<CompraLibro> findAll();

    List<CompraLibro> findRange(int[] range);

    int count();
    
}
