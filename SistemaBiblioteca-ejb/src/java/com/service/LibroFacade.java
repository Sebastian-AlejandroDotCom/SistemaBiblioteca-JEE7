/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Libro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebastian
 */
@Stateless
public class LibroFacade extends AbstractFacade<Libro> implements LibroFacadeLocal {

    @PersistenceContext(unitName = "SistemaBiblioteca-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibroFacade() {
        super(Libro.class);
    }

    @Override
    public List<Libro> findByIsbn(String isbn) {
        List<Libro> list = em.createNamedQuery("Libro.findByIsbn").setParameter("isbn", isbn).getResultList();
        
        if (list == null || list.isEmpty()){
            return null;
        }else{
            return list;
        }
    }
}
