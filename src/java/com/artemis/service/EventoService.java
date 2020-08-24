package com.artemis.service;

import com.artemis.entities.Evento;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EventoService {

    final String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
    final EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();

    public List<Evento> getAllEvento() {
        Query queryObj = entityMgrObj.createQuery("SELECT e FROM Evento e");
        List<Evento> eventolist = queryObj.getResultList();
        if (eventolist != null && eventolist.size() > 0) {
            return eventolist;
        } else {
            return null;
        }
    }

    public Evento getEvento(Integer id) {
        Query queryObj = entityMgrObj.createQuery("SELECT e FROM Evento e WHERE e.id=:id");
        queryObj.setParameter("id", id);
        Evento c = (Evento) queryObj.getSingleResult();
        return c;
    }

    public String createNewEvento(Integer id, String titulo, Date fechaini, Date fechafin, String desc) {
        entityMgrObj.getTransaction().begin();
        Evento e = new Evento();
        e.setId(getMaxEventoId());
        e.setTitulo(titulo);
        e.setFechainicio(fechaini);
        e.setFechafinal(fechafin);
        e.setDescripcion(desc);
        entityMgrObj.persist(e);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
        return "calendarioconf.xhtml?faces-redirect=true";
    }

    public String deleteEvento(Evento e2) {
        FacesMessage message = new FacesMessage();
        try {
            entityMgrObj.getTransaction().begin();
            Evento e1 = entityMgrObj.find(Evento.class, e2.getId());
            entityMgrObj.remove(e1);
            entityMgrObj.getTransaction().commit();
            entityMgrObj.close();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado con éxito", "");
        } catch (Exception e) {
        } finally {
        }
        return "calendarioconf.xhtml?faces-redirect=true";
    }

    public String updateEventoDetails(Integer id, String titulo, Date fechaini, Date fechafin, String desc) {
        entityMgrObj.getTransaction().begin();
        Evento e = entityMgrObj.find(Evento.class, id);
        e.setTitulo(titulo);
        e.setFechainicio(fechaini);
        e.setFechafinal(fechafin);
        e.setDescripcion(desc);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
        return "calendarioconf.xhtml?faces-redirect=true";
    }

    private int getMaxEventoId() {
        int maxeventoid = 1;
        Query queryObj = entityMgrObj.createQuery("SELECT MAX(e.id)+1 FROM Evento e");
        if (queryObj.getSingleResult() != null) {
            maxeventoid = (Integer) queryObj.getSingleResult();
        }
        return maxeventoid;
    }
}
