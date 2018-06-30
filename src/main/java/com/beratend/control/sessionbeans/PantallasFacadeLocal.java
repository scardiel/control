/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beratend.control.sessionbeans;

import com.beratend.control.entidades.Pantallas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alienware
 */
@Local
public interface PantallasFacadeLocal {

    void create(Pantallas pantallas);

    void edit(Pantallas pantallas);

    void remove(Pantallas pantallas);

    Pantallas find(Object id);

    List<Pantallas> findAll();

    List<Pantallas> findRange(int[] range);

    int count();
    
    public List<Pantallas> buscaPantallasPorMenu(int i);
    
}
