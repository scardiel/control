/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beratend.control.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alienware
 */
@Entity
@Table(name = "pantallas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pantallas.findAll", query = "SELECT p FROM Pantallas p")
    , @NamedQuery(name = "Pantallas.findByIdPantalla", query = "SELECT p FROM Pantallas p WHERE p.idPantalla = :idPantalla")
    , @NamedQuery(name = "Pantallas.findByNombre", query = "SELECT p FROM Pantallas p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pantallas.findByLiga", query = "SELECT p FROM Pantallas p WHERE p.liga = :liga")
    , @NamedQuery(name = "Pantallas.findByIdMenu", query = "SELECT p FROM Pantallas p WHERE p.idMenu = :idMenu")
    , @NamedQuery(name = "Pantallas.findByEstatus", query = "SELECT p FROM Pantallas p WHERE p.estatus = :estatus")})
public class Pantallas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPantalla")
    private Integer idPantalla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "liga")
    private String liga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMenu")
    private int idMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private boolean estatus;

    public Pantallas() {
    }

    public Pantallas(Integer idPantalla) {
        this.idPantalla = idPantalla;
    }

    public Pantallas(Integer idPantalla, String nombre, String liga, int idMenu, boolean estatus) {
        this.idPantalla = idPantalla;
        this.nombre = nombre;
        this.liga = liga;
        this.idMenu = idMenu;
        this.estatus = estatus;
    }

    public Integer getIdPantalla() {
        return idPantalla;
    }

    public void setIdPantalla(Integer idPantalla) {
        this.idPantalla = idPantalla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPantalla != null ? idPantalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pantallas)) {
            return false;
        }
        Pantallas other = (Pantallas) object;
        if ((this.idPantalla == null && other.idPantalla != null) || (this.idPantalla != null && !this.idPantalla.equals(other.idPantalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beratend.control.entidades.Pantallas[ idPantalla=" + idPantalla + " ]";
    }
    
}
