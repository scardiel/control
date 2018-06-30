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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alienware
 */
@Entity
@Table(name = "perfiles")
@NamedQueries({
    @NamedQuery(name = "Perfiles.findAll", query = "SELECT p FROM Perfiles p")})
public class Perfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperfiles")
    private Integer idperfiles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private boolean estatus;

    public Perfiles() {
    }

    public Perfiles(Integer idperfiles) {
        this.idperfiles = idperfiles;
    }

    public Perfiles(Integer idperfiles, String descripcion, boolean estatus) {
        this.idperfiles = idperfiles;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    public Integer getIdperfiles() {
        return idperfiles;
    }

    public void setIdperfiles(Integer idperfiles) {
        this.idperfiles = idperfiles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idperfiles != null ? idperfiles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfiles)) {
            return false;
        }
        Perfiles other = (Perfiles) object;
        if ((this.idperfiles == null && other.idperfiles != null) || (this.idperfiles != null && !this.idperfiles.equals(other.idperfiles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beratend.control.entidades.Perfiles[ idperfiles=" + idperfiles + " ]";
    }
    
}
