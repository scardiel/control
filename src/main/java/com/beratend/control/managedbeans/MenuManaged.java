/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beratend.control.managedbeans;

import com.beratend.control.entidades.Permisos;
import com.beratend.control.entidades.Usuarios;
import com.beratend.control.sessionbeans.PermisosFacadeLocal;
import com.beratend.control.sessionbeans.UsuariosFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Josel
 */
@Named(value = "menuManaged")
@SessionScoped
public class MenuManaged implements Serializable {

    /**
     * Creates a new instance of MenuManaged
     */
    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    @EJB
    private PermisosFacadeLocal permisosFacade;

    private MenuModel model;
    private Usuarios unUsuario;
    private List<Usuarios> listaUsuarios;
    private List<Permisos> listaPermisos;

    public MenuManaged() {
        unUsuario = new Usuarios();
    }

    @PostConstruct
    public void init() {
        listaUsuarios = usuariosFacade.usuariosActivos();
        model = new DefaultMenuModel();
        listaPermisos();

    }

    public List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuarios getUnUsuario() {
        return unUsuario;
    }

    public void listaPermisos() {
        try {
            listaPermisos = permisosFacade.findAll();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    public void creaMenu() {
        for (Permisos p : listaPermisos) {
            if (p.getTipo().equals("sub")) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(p.getEtiqueta());
                for (Permisos pi : listaPermisos) {
                    if (pi.getIdSub() == p.getIdPermisos() && unUsuario.getIdperfiles() == pi.getIdPerfil()) {
                        DefaultMenuItem item = new DefaultMenuItem(pi.getEtiqueta());
                        item.setCommand(pi.getLiga());
                        item.setIcon("ui-icon-document");
                        item.setAjax(false);
                        firstSubmenu.addElement(item);
                    }
                }
                model.addElement(firstSubmenu);
            }
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public List<Permisos> getListaPermisos() {
        return listaPermisos;
    }

    public void setListaPermisos(List<Permisos> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }

    public String validaUsuario() {
        Usuarios unUsuarioValidado = usuariosFacade.ValidaUsuario(unUsuario);
        if (unUsuarioValidado == null) {
            return "index";
        } else {
            unUsuario = unUsuarioValidado;
            listaUsuarios = usuariosFacade.findAll();
            FacesContext contextoJSF = FacesContext.getCurrentInstance();
            contextoJSF.getExternalContext().getSessionMap().put("NombreUsuario", unUsuario.getNombre());

            creaMenu();
            return "menu";

        }
    }

    public String logout() {
        FacesContext contextx = FacesContext.getCurrentInstance();
        contextx.getExternalContext().invalidateSession();
        try {
            contextx.getExternalContext().redirect("/control/faces/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/control/faces/index.xhtml";
    }
}
