package com.artemis.beans;

import com.artemis.entities.Auditoriaacceso;
import com.artemis.service.AuditoriaService;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "auditoriaViewController")
@ViewScoped
public class AuditoriaViewController implements Serializable {

    AuditoriaService auditoriaService = new AuditoriaService();

    public AuditoriaViewController() {
    }

    public List<Auditoriaacceso> getListAudit() {
        return auditoriaService.getAllAudit();
    }

}
