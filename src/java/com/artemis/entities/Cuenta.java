/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artemis.entities;

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
 * @author roca12
 */
@Entity
@Table(name = "cuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findById", query = "SELECT c FROM Cuenta c WHERE c.id = :id")
    , @NamedQuery(name = "Cuenta.findByPrimernombre", query = "SELECT c FROM Cuenta c WHERE c.primernombre = :primernombre")
    , @NamedQuery(name = "Cuenta.findBySegundonombre", query = "SELECT c FROM Cuenta c WHERE c.segundonombre = :segundonombre")
    , @NamedQuery(name = "Cuenta.findByPrimerapellido", query = "SELECT c FROM Cuenta c WHERE c.primerapellido = :primerapellido")
    , @NamedQuery(name = "Cuenta.findBySegundoapellido", query = "SELECT c FROM Cuenta c WHERE c.segundoapellido = :segundoapellido")
    , @NamedQuery(name = "Cuenta.findByUsername", query = "SELECT c FROM Cuenta c WHERE c.username = :username")
    , @NamedQuery(name = "Cuenta.findByPass", query = "SELECT c FROM Cuenta c WHERE c.pass = :pass")
    , @NamedQuery(name = "Cuenta.findByRango", query = "SELECT c FROM Cuenta c WHERE c.rango = :rango")
    , @NamedQuery(name = "Cuenta.findByCorreo", query = "SELECT c FROM Cuenta c WHERE c.correo = :correo")})
public class Cuenta implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "rango")
    private int rango;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "primernombre")
    private String primernombre;
    @Size(max = 30)
    @Column(name = "segundonombre")
    private String segundonombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "primerapellido")
    private String primerapellido;
    @Size(max = 30)
    @Column(name = "segundoapellido")
    private String segundoapellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pass")
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;

    public Cuenta() {
    }

    public Cuenta(Integer id) {
        this.id = id;
    }

    public Cuenta(Integer id, String primernombre, String primerapellido, String username, String pass, int rango, String correo) {
        this.id = id;
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
        this.username = username;
        this.pass = pass;
        this.rango = rango;
        this.correo = correo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.artemis.entities.Cuenta[ id=" + id + " ]";
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }
    
}
