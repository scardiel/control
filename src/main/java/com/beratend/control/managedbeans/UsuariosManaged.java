/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beratend.control.managedbeans;

import com.beratend.control.entidades.Usuarios;
import com.beratend.control.sessionbeans.UsuariosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Alienware
 */
@Named(value = "userManaged")
@RequestScoped
public class UsuariosManaged implements Serializable {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    private Usuarios unUsuario;
    private List<Usuarios> listaUsuarios;
    private String titulo;

    /**
     * Creates a new instance of UserManaged
     */
    public UsuariosManaged() {
        unUsuario = new Usuarios();
    }

    @PostConstruct
    public void init() {
        listaUsuarios = usuariosFacade.usuariosActivos();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String listaUsuarios() {
        listaUsuarios = usuariosFacade.usuariosActivos();
        return "catalogos/usuarios";
    }

    public String guardaUsuario() {
        usuariosFacade.edit(unUsuario);
        listaUsuarios = usuariosFacade.usuariosActivos();
        titulo = "Crear";
        unUsuario = null;
        return "";
    }

    public String editaUsuario(Usuarios unUser) {
        unUsuario = unUser;
        titulo = "Editar";
        return "";
    }

    public String creaUsuario() {
        titulo = "Crear";
        return "";
    }
    

    public String borraUsuario(Usuarios unUser) {
        unUser.setEstatus(false);
        usuariosFacade.edit(unUser);
        listaUsuarios = usuariosFacade.usuariosActivos();
        return "usuarios";
    }

    //navigationResult = "createStudent.xhtml?faces-redirect=true";
    public String validaUsuario() {
        Usuarios unUsuarioValidado = usuariosFacade.ValidaUsuario(unUsuario);
        try {
            if (unUsuarioValidado == null) {
                return "index";
            } else {
                unUsuario = unUsuarioValidado;
                return "menu";
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return "index";
    }

}
