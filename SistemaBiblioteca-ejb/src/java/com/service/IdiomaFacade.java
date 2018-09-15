/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Idioma;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebastian
 */
@Stateless
public class IdiomaFacade extends AbstractFacade<Idioma> implements IdiomaFacadeLocal {

    @PersistenceContext(unitName = "SistemaBiblioteca-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IdiomaFacade() {
        super(Idioma.class);
    }
    
    @Override
    public List<Idioma> findById(Integer id) {
        List<Idioma> list = em.createNamedQuery("Idioma.findByIdIdioma").setParameter("idIdioma", id).getResultList();
        
        if (list == null || list.isEmpty()){
            return null;
        }else{
            return list;
        }
    }
}
