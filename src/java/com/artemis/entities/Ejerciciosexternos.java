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
@Table(name = "ejerciciosexternos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejerciciosexternos.findAll", query = "SELECT e FROM Ejerciciosexternos e")
    , @NamedQuery(name = "Ejerciciosexternos.findById", query = "SELECT e FROM Ejerciciosexternos e WHERE e.id = :id")
    , @NamedQuery(name = "Ejerciciosexternos.findByTitle", query = "SELECT e FROM Ejerciciosexternos e WHERE e.title = :title")
    , @NamedQuery(name = "Ejerciciosexternos.findByJudge", query = "SELECT e FROM Ejerciciosexternos e WHERE e.judge = :judge")
    , @NamedQuery(name = "Ejerciciosexternos.findByJudgeid", query = "SELECT e FROM Ejerciciosexternos e WHERE e.judgeid = :judgeid")
    , @NamedQuery(name = "Ejerciciosexternos.findByDifficult", query = "SELECT e FROM Ejerciciosexternos e WHERE e.difficult = :difficult")
    , @NamedQuery(name = "Ejerciciosexternos.findByType1", query = "SELECT e FROM Ejerciciosexternos e WHERE e.type1 = :type1")
    , @NamedQuery(name = "Ejerciciosexternos.findByType2", query = "SELECT e FROM Ejerciciosexternos e WHERE e.type2 = :type2")
    , @NamedQuery(name = "Ejerciciosexternos.findByType3", query = "SELECT e FROM Ejerciciosexternos e WHERE e.type3 = :type3")
    , @NamedQuery(name = "Ejerciciosexternos.findByType4", query = "SELECT e FROM Ejerciciosexternos e WHERE e.type4 = :type4")
    , @NamedQuery(name = "Ejerciciosexternos.findByUrl", query = "SELECT e FROM Ejerciciosexternos e WHERE e.url = :url")})
public class Ejerciciosexternos implements Serializable {

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
    @Size(min = 1, max = 50)
    @Column(name = "judge")
    private String judge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "judgeid")
    private String judgeid;
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
    @Size(min = 1, max = 1000)
    @Column(name = "url")
    private String url;

    public Ejerciciosexternos() {
    }

    public Ejerciciosexternos(Integer id) {
        this.id = id;
    }

    public Ejerciciosexternos(Integer id, String title, String judge, String judgeid, int difficult, String type1, String url) {
        this.id = id;
        this.title = title;
        this.judge = judge;
        this.judgeid = judgeid;
        this.difficult = difficult;
        this.type1 = type1;
        this.url = url;
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

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getJudgeid() {
        return judgeid;
    }

    public void setJudgeid(String judgeid) {
        this.judgeid = judgeid;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof Ejerciciosexternos)) {
            return false;
        }
        Ejerciciosexternos other = (Ejerciciosexternos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.artemis.entities.Ejerciciosexternos[ id=" + id + " ]";
    }
    
}
