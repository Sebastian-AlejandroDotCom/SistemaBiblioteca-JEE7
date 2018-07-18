/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.ClienteDireccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface ClienteDireccionFacadeLocal {

    void create(ClienteDireccion clienteDireccion);

    void edit(ClienteDireccion clienteDireccion);

    void remove(ClienteDireccion clienteDireccion);

    ClienteDireccion find(Object id);

    List<ClienteDireccion> findAll();

    List<ClienteDireccion> findRange(int[] range);

    int count();
    
}
