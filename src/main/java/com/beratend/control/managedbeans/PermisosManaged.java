/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beratend.control.managedbeans;

import com.beratend.control.entidades.Menus;
import com.beratend.control.entidades.Pantallas;
import com.beratend.control.entidades.Perfiles;
import com.beratend.control.entidades.Permisos;
import com.beratend.control.sessionbeans.MenusFacadeLocal;
import com.beratend.control.sessionbeans.PantallasFacadeLocal;
import com.beratend.control.sessionbeans.PerfilesFacadeLocal;
import com.beratend.control.sessionbeans.PermisosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Josel
 */
@Named(value = "permisosManaged")
@ApplicationScoped
public class PermisosManaged implements Serializable {

    /**
     * Creates a new instance of PermisosManaged
     */
    @EJB
    private PermisosFacadeLocal permisosFacade;
    @EJB
    private PerfilesFacadeLocal perfilesFacade;
    @EJB
    private MenusFacadeLocal menusFacade;
    @EJB
    private PantallasFacadeLocal pantallasFacade;

    private List<Permisos> listaPermisos;
    private Permisos unPermiso;
    private String titulo;

    private List<Perfiles> listaPerfiles;
    private List<Menus> listaMenus;
    private List<Pantallas> listaPantallas;

    private Perfiles unPerfil;

    private boolean menuPerfil = false;
    private boolean menuMenus = true;
    private boolean menuPantallas = true;

    public PermisosManaged() {
        unPermiso = new Permisos();
        unPerfil = new Perfiles();
        unPerfil.setIdperfiles(0);
        titulo = "Agregar permisos";
    }

    @PostConstruct
    public void init() {

        try {
            listaPerfiles = perfilesFacade.findAll();
            listaPermisos = permisosFacade.buscaPermisosPorPerfil(unPerfil.getIdperfiles());
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }

    public String guardaPermisos() {
        permisosFacade.edit(unPermiso);
        unPermiso = null;
        titulo = "Agregar permisos";
        listaPermisos = permisosFacade.buscaPermisosPorPerfil(unPerfil.getIdperfiles());
        return "";
    }

    public String borraPermisos(Permisos item) {
        permisosFacade.remove(item);
        listaPermisos = permisosFacade.buscaPermisosPorPerfil(unPerfil.getIdperfiles());
        return "";
    }

    public String editaPermisos(Permisos item) {
        unPermiso = item;
        titulo = "Editar permisos";
        return "";
    }

    public void cambioPerfil() {
        listaPermisos = permisosFacade.buscaPermisosPorPerfil(unPerfil.getIdperfiles());
        menuMenus = false;
        menuPerfil = true;
        listaMenus = menusFacade.findAll();
        System.out.println("Cambio Perfil");
    }

    public void cambioMenus() {
        menuMenus = true;
        try {
            listaPermisos = permisosFacade.buscaPermisosPorPerfil(unPerfil.getIdperfiles());
            listaPantallas = pantallasFacade.buscaPantallasPorMenu(unPermiso.getIdSub());
            menuPantallas = false;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void cambioPantallas() {

    }

    public List<Permisos> getListaPermisos() {
        return listaPermisos;
    }

    public void setListaPermisos(List<Permisos> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }

    public Permisos getUnPermiso() {
        return unPermiso;
    }

    public void setUnPermiso(Permisos unPermiso) {
        this.unPermiso = unPermiso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Perfiles> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(List<Perfiles> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    public List<Menus> getListaMenus() {
        return listaMenus;
    }

    public void setListaMenus(List<Menus> listaMenus) {
        this.listaMenus = listaMenus;
    }

    public List<Pantallas> getListaPantallas() {
        return listaPantallas;
    }

    public void setListaPantallas(List<Pantallas> listaPantallas) {
        this.listaPantallas = listaPantallas;
    }

    public Perfiles getUnPerfil() {
        return unPerfil;
    }

    public void setUnPerfil(Perfiles unPerfil) {
        this.unPerfil = unPerfil;
    }

    public boolean isMenuPerfil() {
        return menuPerfil;
    }

    public void setMenuPerfil(boolean menuPerfil) {
        this.menuPerfil = menuPerfil;
    }

    public boolean isMenuMenus() {
        return menuMenus;
    }

    public void setMenuMenus(boolean menuMenus) {
        this.menuMenus = menuMenus;
    }

    public boolean isMenuPantallas() {
        return menuPantallas;
    }

    public void setMenuPantallas(boolean menuPantallas) {
        this.menuPantallas = menuPantallas;
    }

}
