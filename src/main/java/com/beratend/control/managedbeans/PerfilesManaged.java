/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beratend.control.managedbeans;

import com.beratend.control.entidades.Perfiles;
import com.beratend.control.sessionbeans.PerfilesFacadeLocal;
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
@Named(value = "perfilesManaged")
@ApplicationScoped
public class PerfilesManaged implements Serializable {

    @EJB
    private PerfilesFacadeLocal perfilesFacade;

    private Perfiles unPerfil;
    private int idPerfiles;
    private String descripcion;
    private List<Perfiles> listaPerfiles;
    private int estatus;
    private String titulo;

    /**
     * Creates a new instance of PerfilesManaged
     */
    public PerfilesManaged() {
        unPerfil = new Perfiles();
    }

    @PostConstruct
    public void init() {
        listaPerfiles = perfilesFacade.findAll();
    }

    public String guardaPerfiles() {
        perfilesFacade.edit(unPerfil);
        unPerfil = null;
        titulo = "Crear";
        listaPerfiles = perfilesFacade.findAll();
        return "";
    }
    
    public String borraPerfiles(Perfiles item) {
        perfilesFacade.remove(item);
        listaPerfiles = perfilesFacade.findAll();
        return "";
    }
    
    public String editaPerfiles(Perfiles item) {
        unPerfil = item;
        titulo = "Editar";
        return "";
    }
      public List<Perfiles> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(List<Perfiles> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

 
    public Perfiles getUnPerfil() {
        return unPerfil;
    }

    public void setUnPerfil(Perfiles unPerfil) {
        this.unPerfil = unPerfil;
    }

    public int getIdPerfiles() {
        return idPerfiles;
    }

    public void setIdPerfiles(int idPerfiles) {
        this.idPerfiles = idPerfiles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
