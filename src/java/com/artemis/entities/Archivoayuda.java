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
@Table(name = "archivosayuda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivoayuda.findAll", query = "SELECT a FROM Archivoayuda a")
    , @NamedQuery(name = "Archivoayuda.findById", query = "SELECT a FROM Archivoayuda a WHERE a.id = :id")
    , @NamedQuery(name = "Archivoayuda.findByFileName", query = "SELECT a FROM Archivoayuda a WHERE a.fileName = :fileName")
    , @NamedQuery(name = "Archivoayuda.findByFileExtension", query = "SELECT a FROM Archivoayuda a WHERE a.fileExtension = :fileExtension")
    , @NamedQuery(name = "Archivoayuda.findByDescription", query = "SELECT a FROM Archivoayuda a WHERE a.description = :description")})
public class Archivoayuda implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "FILE_DATA")
    private byte[] fileData;

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FILE_NAME")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FILE_EXTENSION")
    private String fileExtension;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;

    public Archivoayuda() {
    }

    public Archivoayuda(Long id) {
        this.id = id;
    }

    public Archivoayuda(Long id, String fileName, byte[] fileData, String fileExtension) {
        this.id = id;
        this.fileName = fileName;
        this.fileData = fileData;
        this.fileExtension = fileExtension;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Archivoayuda)) {
            return false;
        }
        Archivoayuda other = (Archivoayuda) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.artemis.entities.Archivoayuda[ id=" + id + " ]";
    }
    
}
