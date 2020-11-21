/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemapuntos.segundofinal.modelo;

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
 * @author Adrián
 */
@Entity
@Table(name = "mecanico_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MecanicoStatus.findAll", query = "SELECT m FROM MecanicoStatus m")
    , @NamedQuery(name = "MecanicoStatus.findByIdMecanico", query = "SELECT m FROM MecanicoStatus m WHERE m.idMecanico = :idMecanico")
    , @NamedQuery(name = "MecanicoStatus.findByStatus", query = "SELECT m FROM MecanicoStatus m WHERE m.status = :status")})
public class MecanicoStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_mecanico")
    private Integer idMecanico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;

    public MecanicoStatus() {
    }

    public MecanicoStatus(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public MecanicoStatus(Integer idMecanico, String status) {
        this.idMecanico = idMecanico;
        this.status = status;
    }

    public Integer getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMecanico != null ? idMecanico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MecanicoStatus)) {
            return false;
        }
        MecanicoStatus other = (MecanicoStatus) object;
        if ((this.idMecanico == null && other.idMecanico != null) || (this.idMecanico != null && !this.idMecanico.equals(other.idMecanico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemapuntos.segundofinal.modelo.MecanicoStatus[ idMecanico=" + idMecanico + " ]";
    }
    
}
