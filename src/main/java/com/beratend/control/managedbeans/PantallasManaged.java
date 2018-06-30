/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beratend.control.managedbeans;

import com.beratend.control.entidades.Menus;
import com.beratend.control.entidades.Pantallas;
import com.beratend.control.sessionbeans.MenusFacadeLocal;
import com.beratend.control.sessionbeans.PantallasFacadeLocal;
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
@Named(value = "pantallasManaged")
@ApplicationScoped
public class PantallasManaged implements Serializable {

    /**
     * Creates a new instance of PantallasManaged
     */
    @EJB
    private PantallasFacadeLocal pantallasFacade;
    
    @EJB
    private MenusFacadeLocal menusFacade;
    
    private List<Pantallas> listaPantallas;
    private Pantallas unaPantalla;
    private String titulo;
    private List<Menus> listaMenus;
    private Menus menus;
    
    
    public PantallasManaged() {
        unaPantalla = new Pantallas();
        titulo = "Crear";
    }
    
    @PostConstruct
    public void init() {
        listaPantallas = pantallasFacade.findAll();
        listaMenus = menusFacade.findAll();
    }
    
    public String guardaPantallas() {
        pantallasFacade.edit(unaPantalla);
        unaPantalla = new Pantallas();
        titulo = "Crear";
        listaPantallas = pantallasFacade.findAll();
        return "";
    }
    
    public String borraPantallas(Pantallas item) {
        pantallasFacade.remove(item);
        listaPantallas = pantallasFacade.findAll();
        return "";
    }
    
    public String editaPantallas(Pantallas item) {
        unaPantalla = item;
        titulo = "Editar";
        return "";
    }
    
    public List<Pantallas> getListaPantallas() {
        return listaPantallas;
    }
    
    public void setListaPantallas(List<Pantallas> listaPantallas) {
        this.listaPantallas = listaPantallas;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Pantallas getUnaPantalla() {
        return unaPantalla;
    }
    
    public void setUnaPantalla(Pantallas unaPantalla) {
        this.unaPantalla = unaPantalla;
    }

    public List<Menus> getListaMenus() {
        return listaMenus;
    }

    public void setListaMenus(List<Menus> listaMenus) {
        this.listaMenus = listaMenus;
    }

    public Menus getMenus() {
        return menus;
    }

    public void setMenus(Menus menus) {
        this.menus = menus;
    }
    
}
