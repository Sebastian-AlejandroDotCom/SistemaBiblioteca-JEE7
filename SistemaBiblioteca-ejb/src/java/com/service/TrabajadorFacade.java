/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Trabajador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebastian
 */
@Stateless
public class TrabajadorFacade extends AbstractFacade<Trabajador> implements TrabajadorFacadeLocal {

    @PersistenceContext(unitName = "SistemaBiblioteca-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajadorFacade() {
        super(Trabajador.class);
    }
    
}
