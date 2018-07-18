/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.TrabajadorTelefono;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebastian
 */
@Stateless
public class TrabajadorTelefonoFacade extends AbstractFacade<TrabajadorTelefono> implements TrabajadorTelefonoFacadeLocal {

    @PersistenceContext(unitName = "SistemaBiblioteca-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajadorTelefonoFacade() {
        super(TrabajadorTelefono.class);
    }
    
}
