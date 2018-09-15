/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Editorial;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebastian
 */
@Stateless
public class EditorialFacade extends AbstractFacade<Editorial> implements EditorialFacadeLocal {

    @PersistenceContext(unitName = "SistemaBiblioteca-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EditorialFacade() {
        super(Editorial.class);
    }
    
    @Override
    public List<Editorial> findById(Integer id) {
        List<Editorial> list = em.createNamedQuery("Editorial.findByIdEditorial").setParameter("idEditorial", id).getResultList();
        
        if (list == null || list.isEmpty()){
            return null;
        }else{
            return list;
        }
    }
}
