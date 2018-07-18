/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.ClienteTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface ClienteTelefonoFacadeLocal {

    void create(ClienteTelefono clienteTelefono);

    void edit(ClienteTelefono clienteTelefono);

    void remove(ClienteTelefono clienteTelefono);

    ClienteTelefono find(Object id);

    List<ClienteTelefono> findAll();

    List<ClienteTelefono> findRange(int[] range);

    int count();
    
}
