/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.ArriendoLibro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface ArriendoLibroFacadeLocal {

    void create(ArriendoLibro arriendoLibro);

    void edit(ArriendoLibro arriendoLibro);

    void remove(ArriendoLibro arriendoLibro);

    ArriendoLibro find(Object id);

    List<ArriendoLibro> findAll();

    List<ArriendoLibro> findRange(int[] range);

    int count();
    
}
