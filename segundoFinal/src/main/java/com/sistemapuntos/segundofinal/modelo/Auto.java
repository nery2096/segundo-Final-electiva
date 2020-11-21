/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemapuntos.segundofinal.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrián
 */
@Entity
@Table(name = "auto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auto.findAll", query = "SELECT a FROM Auto a")
    , @NamedQuery(name = "Auto.findByIdAuto", query = "SELECT a FROM Auto a WHERE a.idAuto = :idAuto")
    , @NamedQuery(name = "Auto.findByMatricula", query = "SELECT a FROM Auto a WHERE a.matricula = :matricula")
    , @NamedQuery(name = "Auto.findByModelo", query = "SELECT a FROM Auto a WHERE a.modelo = :modelo")
    , @NamedQuery(name = "Auto.findByColor", query = "SELECT a FROM Auto a WHERE a.color = :color")})
public class Auto implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAuto")
    private Collection<MecanicoPorAuto> mecanicoPorAutoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_auto")
    private Integer idAuto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "color")
    private String color;
    @JoinTable(name = "mecanico_por_auto", joinColumns = {
        @JoinColumn(name = "id_auto", referencedColumnName = "id_auto")}, inverseJoinColumns = {
        @JoinColumn(name = "id_mecanico", referencedColumnName = "id_usuario")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAuto")
    private Collection<Taller> tallerCollection;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idCliente;

    public Auto() {
    }

    public Auto(Integer idAuto) {
        this.idAuto = idAuto;
    }

    public Auto(Integer idAuto, String matricula, String modelo, String color) {
        this.idAuto = idAuto;
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
    }

    public Integer getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(Integer idAuto) {
        this.idAuto = idAuto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Taller> getTallerCollection() {
        return tallerCollection;
    }

    public void setTallerCollection(Collection<Taller> tallerCollection) {
        this.tallerCollection = tallerCollection;
    }

    public Usuario getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuario idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuto != null ? idAuto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auto)) {
            return false;
        }
        Auto other = (Auto) object;
        if ((this.idAuto == null && other.idAuto != null) || (this.idAuto != null && !this.idAuto.equals(other.idAuto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemapuntos.segundofinal.modelo.Auto[ idAuto=" + idAuto + " ]";
    }

    @XmlTransient
    public Collection<MecanicoPorAuto> getMecanicoPorAutoCollection() {
        return mecanicoPorAutoCollection;
    }

    public void setMecanicoPorAutoCollection(Collection<MecanicoPorAuto> mecanicoPorAutoCollection) {
        this.mecanicoPorAutoCollection = mecanicoPorAutoCollection;
    }
    
}
