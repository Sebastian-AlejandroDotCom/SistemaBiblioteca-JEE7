/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.EstadoLibro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface EstadoLibroFacadeLocal {

    void create(EstadoLibro estadoLibro);

    void edit(EstadoLibro estadoLibro);

    void remove(EstadoLibro estadoLibro);

    EstadoLibro find(Object id);

    List<EstadoLibro> findAll();

    List<EstadoLibro> findRange(int[] range);

    int count();
    
}
