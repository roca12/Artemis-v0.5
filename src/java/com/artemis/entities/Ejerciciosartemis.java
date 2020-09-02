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
import javax.persistence.Lob;
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
@Table(name = "ejerciciosartemis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejerciciosartemis.findAll", query = "SELECT e FROM Ejerciciosartemis e")
    , @NamedQuery(name = "Ejerciciosartemis.findById", query = "SELECT e FROM Ejerciciosartemis e WHERE e.id = :id")
    , @NamedQuery(name = "Ejerciciosartemis.findByTitle", query = "SELECT e FROM Ejerciciosartemis e WHERE e.title = :title")
    , @NamedQuery(name = "Ejerciciosartemis.findByAlias", query = "SELECT e FROM Ejerciciosartemis e WHERE e.alias = :alias")
    , @NamedQuery(name = "Ejerciciosartemis.findByDifficult", query = "SELECT e FROM Ejerciciosartemis e WHERE e.difficult = :difficult")
    , @NamedQuery(name = "Ejerciciosartemis.findByType1", query = "SELECT e FROM Ejerciciosartemis e WHERE e.type1 = :type1")
    , @NamedQuery(name = "Ejerciciosartemis.findByType2", query = "SELECT e FROM Ejerciciosartemis e WHERE e.type2 = :type2")
    , @NamedQuery(name = "Ejerciciosartemis.findByType3", query = "SELECT e FROM Ejerciciosartemis e WHERE e.type3 = :type3")
    , @NamedQuery(name = "Ejerciciosartemis.findByType4", query = "SELECT e FROM Ejerciciosartemis e WHERE e.type4 = :type4")
    , @NamedQuery(name = "Ejerciciosartemis.findByExt", query = "SELECT e FROM Ejerciciosartemis e WHERE e.ext = :ext")})
public class Ejerciciosartemis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "difficult")
    private int difficult;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type1")
    private String type1;
    @Size(max = 50)
    @Column(name = "type2")
    private String type2;
    @Size(max = 50)
    @Column(name = "type3")
    private String type3;
    @Size(max = 50)
    @Column(name = "type4")
    private String type4;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "file")
    private byte[] file;
    @Size(max = 10)
    @Column(name = "ext")
    private String ext;

    public Ejerciciosartemis() {
    }

    public Ejerciciosartemis(Integer id) {
        this.id = id;
    }

    public Ejerciciosartemis(Integer id, String title, String alias, int difficult, String type1, byte[] file) {
        this.id = id;
        this.title = title;
        this.alias = alias;
        this.difficult = difficult;
        this.type1 = type1;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
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
        if (!(object instanceof Ejerciciosartemis)) {
            return false;
        }
        Ejerciciosartemis other = (Ejerciciosartemis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.artemis.entities.Ejerciciosartemis[ id=" + id + " ]";
    }
    
}
