/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beratend.control.sessionbeans;

import com.beratend.control.entidades.Pantallas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alienware
 */
@Stateless
public class PantallasFacade extends AbstractFacade<Pantallas> implements PantallasFacadeLocal {

    @PersistenceContext(unitName = "com.beratend_control_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PantallasFacade() {
        super(Pantallas.class);
    }
    
    @Override
    public List<Pantallas> buscaPantallasPorMenu(int i) {
        List<Pantallas> paso;
        paso = em.createNamedQuery("Pantallas.findByIdMenu").setParameter("idMenu", i).getResultList();
        return paso;
    }
    
}
