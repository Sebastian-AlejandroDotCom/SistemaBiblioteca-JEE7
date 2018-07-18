/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.ArriendoLibro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebastian
 */
@Stateless
public class ArriendoLibroFacade extends AbstractFacade<ArriendoLibro> implements ArriendoLibroFacadeLocal {

    @PersistenceContext(unitName = "SistemaBiblioteca-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArriendoLibroFacade() {
        super(ArriendoLibro.class);
    }
    
}
