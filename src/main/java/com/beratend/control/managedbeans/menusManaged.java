/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beratend.control.managedbeans;

import com.beratend.control.entidades.Menus;
import com.beratend.control.sessionbeans.MenusFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Alienware
 */
@Named(value = "menusManaged")
@ApplicationScoped
public class menusManaged implements Serializable{

    @EJB
    private MenusFacadeLocal menusFacade;

    private List<Menus> listaMenus;
    private Menus unMenu;
    private String unTitulo;



    public MenusFacadeLocal getMenusFacade() {
        return menusFacade;
    }

    public void setMenusFacade(MenusFacadeLocal menusFacade) {
        this.menusFacade = menusFacade;
    }

    public String getUnTitulo() {
        return unTitulo;
    }

    public void setUnTitulo(String unTitulo) {
        this.unTitulo = unTitulo;
    }

    /**
     * Creates a new instance of menusManaged
     */
    public menusManaged() {
        unMenu = new Menus();
    }

    public Menus getUnMenu() {
        return unMenu;
    }

    public void setUnMenu(Menus unMenu) {
        this.unMenu = unMenu;
    }

    @PostConstruct
    public void init() {
        listaMenus = menusFacade.findAll();
        unTitulo = "Crear";
    }

    public List<Menus> getListaMenus() {
        return listaMenus;
    }

    public void setListaMenus(List<Menus> listaMenus) {
        this.listaMenus = listaMenus;
    }

    public String guardaMenus() {
        menusFacade.edit(unMenu);
        listaMenus = menusFacade.findAll();
        unMenu = new Menus();
        return "";
    }

    public String editaMenus(Menus item) {
        unTitulo = "Editar";
        unMenu = item;
        return "";
    }

    public String borraMenus(Menus item) {
        try {
        menusFacade.remove(item);
        listaMenus = menusFacade.findAll();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return "";
    }

}
