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
@Table(name = "hoja_repuestos_usados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HojaRepuestosUsados.findAll", query = "SELECT h FROM HojaRepuestosUsados h")
    , @NamedQuery(name = "HojaRepuestosUsados.findByIdHoja", query = "SELECT h FROM HojaRepuestosUsados h WHERE h.idHoja = :idHoja")
    , @NamedQuery(name = "HojaRepuestosUsados.findByDescripcionRepuesto", query = "SELECT h FROM HojaRepuestosUsados h WHERE h.descripcionRepuesto = :descripcionRepuesto")
    , @NamedQuery(name = "HojaRepuestosUsados.findByPrecio", query = "SELECT h FROM HojaRepuestosUsados h WHERE h.precio = :precio")})
public class HojaRepuestosUsados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hoja")
    private Integer idHoja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion_repuesto")
    private String descripcionRepuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHoja")
    private Collection<Factura> facturaCollection;

    public HojaRepuestosUsados() {
    }

    public HojaRepuestosUsados(Integer idHoja) {
        this.idHoja = idHoja;
    }

    public HojaRepuestosUsados(Integer idHoja, String descripcionRepuesto, int precio) {
        this.idHoja = idHoja;
        this.descripcionRepuesto = descripcionRepuesto;
        this.precio = precio;
    }

    public Integer getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(Integer idHoja) {
        this.idHoja = idHoja;
    }

    public String getDescripcionRepuesto() {
        return descripcionRepuesto;
    }

    public void setDescripcionRepuesto(String descripcionRepuesto) {
        this.descripcionRepuesto = descripcionRepuesto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHoja != null ? idHoja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HojaRepuestosUsados)) {
            return false;
        }
        HojaRepuestosUsados other = (HojaRepuestosUsados) object;
        if ((this.idHoja == null && other.idHoja != null) || (this.idHoja != null && !this.idHoja.equals(other.idHoja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemapuntos.segundofinal.modelo.HojaRepuestosUsados[ idHoja=" + idHoja + " ]";
    }
    
}
