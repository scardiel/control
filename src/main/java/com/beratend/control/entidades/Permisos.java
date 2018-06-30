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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josel
 */
@Entity
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p")
    , @NamedQuery(name = "Permisos.findByIdPermisos", query = "SELECT p FROM Permisos p WHERE p.idPerfil = :idPermisos")
    , @NamedQuery(name = "Permisos.PermisosXPerfil", query = "SELECT p FROM Permisos p WHERE p.idPerfil = :idPerfil and p.tipo = 'item'")
    , @NamedQuery(name = "Permisos.findByEtiqueta", query = "SELECT p FROM Permisos p WHERE p.etiqueta = :etiqueta")
    , @NamedQuery(name = "Permisos.findByTipo", query = "SELECT p FROM Permisos p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Permisos.findByIdSub", query = "SELECT p FROM Permisos p WHERE p.idSub = :idSub")
    , @NamedQuery(name = "Permisos.findByIdPerfil", query = "SELECT p FROM Permisos p WHERE p.idPerfil = :idPerfil")
    , @NamedQuery(name = "Permisos.findByAlta", query = "SELECT p FROM Permisos p WHERE p.alta = :alta")
    , @NamedQuery(name = "Permisos.findByBaja", query = "SELECT p FROM Permisos p WHERE p.baja = :baja")
    , @NamedQuery(name = "Permisos.findByEditar", query = "SELECT p FROM Permisos p WHERE p.editar = :editar")
    , @NamedQuery(name = "Permisos.findByConsultar", query = "SELECT p FROM Permisos p WHERE p.consultar = :consultar")
    , @NamedQuery(name = "Permisos.findByImprimir", query = "SELECT p FROM Permisos p WHERE p.imprimir = :imprimir")
    , @NamedQuery(name = "Permisos.findByImportar", query = "SELECT p FROM Permisos p WHERE p.importar = :importar")
    , @NamedQuery(name = "Permisos.findByExportar", query = "SELECT p FROM Permisos p WHERE p.exportar = :exportar")
    , @NamedQuery(name = "Permisos.findByEstatus", query = "SELECT p FROM Permisos p WHERE p.estatus = :estatus")
    , @NamedQuery(name = "Permisos.findByLiga", query = "SELECT p FROM Permisos p WHERE p.liga = :liga")})
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPermisos")
    private Integer idPermisos;
    @Size(max = 45)
    @Column(name = "etiqueta")
    private String etiqueta;
    @Size(max = 4)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "idSub")
    private Integer idSub;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPerfil")
    private int idPerfil;
    @Column(name = "alta")
    private Boolean alta;
    @Column(name = "baja")
    private Boolean baja;
    @Column(name = "editar")
    private Boolean editar;
    @Column(name = "consultar")
    private Boolean consultar;
    @Column(name = "imprimir")
    private Boolean imprimir;
    @Column(name = "importar")
    private Boolean importar;
    @Column(name = "exportar")
    private Boolean exportar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private boolean estatus;
    @Size(max = 45)
    @Column(name = "liga")
    private String liga;

    public Permisos() {
    }

    public Permisos(Integer idPermisos) {
        this.idPermisos = idPermisos;
    }

    public Permisos(Integer idPermisos, int idPerfil, boolean estatus) {
        this.idPermisos = idPermisos;
        this.idPerfil = idPerfil;
        this.estatus = estatus;
    }

    public Integer getIdPermisos() {
        return idPermisos;
    }

    public void setIdPermisos(Integer idPermisos) {
        this.idPermisos = idPermisos;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdSub() {
        return idSub;
    }

    public void setIdSub(Integer idSub) {
        this.idSub = idSub;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Boolean getBaja() {
        return baja;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Boolean getConsultar() {
        return consultar;
    }

    public void setConsultar(Boolean consultar) {
        this.consultar = consultar;
    }

    public Boolean getImprimir() {
        return imprimir;
    }

    public void setImprimir(Boolean imprimir) {
        this.imprimir = imprimir;
    }

    public Boolean getImportar() {
        return importar;
    }

    public void setImportar(Boolean importar) {
        this.importar = importar;
    }

    public Boolean getExportar() {
        return exportar;
    }

    public void setExportar(Boolean exportar) {
        this.exportar = exportar;
    }

    public boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermisos != null ? idPermisos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.idPermisos == null && other.idPermisos != null) || (this.idPermisos != null && !this.idPermisos.equals(other.idPermisos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beratend.control.entidades.Permisos[ idPermisos=" + idPermisos + " ]";
    }

}
