/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artemis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roca12
 */
@Entity
@Table(name = "auditoriaacceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoriaacceso.findAll", query = "SELECT a FROM Auditoriaacceso a")
    , @NamedQuery(name = "Auditoriaacceso.findById", query = "SELECT a FROM Auditoriaacceso a WHERE a.id = :id")
    , @NamedQuery(name = "Auditoriaacceso.findByUsername", query = "SELECT a FROM Auditoriaacceso a WHERE a.username = :username")
    , @NamedQuery(name = "Auditoriaacceso.findByFechaentrada", query = "SELECT a FROM Auditoriaacceso a WHERE a.fechaentrada = :fechaentrada")
    , @NamedQuery(name = "Auditoriaacceso.findByHosturl", query = "SELECT a FROM Auditoriaacceso a WHERE a.hosturl = :hosturl")})
public class Auditoriaacceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "username")
    private String username;
    @Column(name = "fechaentrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaentrada;
    @Size(max = 400)
    @Column(name = "hosturl")
    private String hosturl;

    public Auditoriaacceso() {
    }

    public Auditoriaacceso(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public String getHosturl() {
        return hosturl;
    }

    public void setHosturl(String hosturl) {
        this.hosturl = hosturl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoriaacceso)) {
            return false;
        }
        Auditoriaacceso other = (Auditoriaacceso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.artemis.entities.Auditoriaacceso[ id=" + id + " ]";
    }
    
}
