/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Arriendo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface ArriendoFacadeLocal {

    void create(Arriendo arriendo);

    void edit(Arriendo arriendo);

    void remove(Arriendo arriendo);

    Arriendo find(Object id);

    List<Arriendo> findAll();

    List<Arriendo> findRange(int[] range);

    int count();
    
}
