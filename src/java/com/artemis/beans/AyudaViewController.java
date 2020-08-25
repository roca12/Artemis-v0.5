package com.artemis.beans;

import com.artemis.entities.Archivoayuda;
import com.artemis.service.AyudaService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

@Named(value = "ayudaViewController")
@SessionScoped
public class AyudaViewController implements Serializable {

    private UploadedFile file;

    public AyudaViewController() {
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile uf = event.getFile();
        AyudaService ayudaService2= new AyudaService();
        ayudaService2.createNewFile(uf.getFileName(), uf.getContent(), uf.getContentType(), "Ayuda");
        FacesMessage msg = new FacesMessage("Correcto", event.getFile().getFileName() + " se ha subido correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    Archivoayuda archseleccionado;

    public Archivoayuda getArchseleccionado() {
        return archseleccionado;
    }

    public void setArchseleccionado(Archivoayuda archseleccionado) {
        this.archseleccionado = archseleccionado;
    }

    public List<Archivoayuda> getArchivosList() {
        AyudaService ayudaService2= new AyudaService();
        return ayudaService2.getAllFiles();
    }

    public String deleteArchById() {
        AyudaService ayudaService2= new AyudaService();
        ayudaService2.deleteFile(archseleccionado);
        return "ayudaconf.xhtml?faces-redirect=true";
    }

}
