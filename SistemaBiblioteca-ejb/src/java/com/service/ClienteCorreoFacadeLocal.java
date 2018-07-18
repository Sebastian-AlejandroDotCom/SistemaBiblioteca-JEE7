/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.ClienteCorreo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface ClienteCorreoFacadeLocal {

    void create(ClienteCorreo clienteCorreo);

    void edit(ClienteCorreo clienteCorreo);

    void remove(ClienteCorreo clienteCorreo);

    ClienteCorreo find(Object id);

    List<ClienteCorreo> findAll();

    List<ClienteCorreo> findRange(int[] range);

    int count();
    
}
