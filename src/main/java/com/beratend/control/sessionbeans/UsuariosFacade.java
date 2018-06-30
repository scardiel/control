/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beratend.control.sessionbeans;

import com.beratend.control.entidades.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alienware
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "com.beratend_control_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios ValidaUsuario(Usuarios usuario) {
        Usuarios unUsuarioValidado;
        unUsuarioValidado = (Usuarios)em.createNamedQuery("Usuario.ValidaUsuario").setParameter("usuario", usuario.getUsuario()).setParameter("password", usuario.getPassword()).getSingleResult();
        return unUsuarioValidado;
    }

    @Override
    public List<Usuarios> usuariosActivos() {
        List<Usuarios> paso;
        paso = em.createNamedQuery("Usuarios.usuariosActivos").getResultList();
        return paso;
    }
    
    
}
