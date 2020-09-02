package com.artemis.service;

import com.artemis.entities.Ejerciciosexternos;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProblemasService {
    
    final String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
    final EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    
    public List<Ejerciciosexternos> getAllEjerExternos() {
        Query queryObj = entityMgrObj.createQuery("SELECT e FROM Ejerciciosexternos e");
        List<Ejerciciosexternos> ejercicioslist = queryObj.getResultList();
        if (ejercicioslist != null && ejercicioslist.size() > 0) {
            return ejercicioslist;
        } else {
            return null;
        }
    }
    
    public Ejerciciosexternos getEjerExternos(Integer id) {
        Query queryObj = entityMgrObj.createQuery("SELECT e FROM Ejerciciosexternos e WHERE e.id=:id");
        queryObj.setParameter("id", id);
        Ejerciciosexternos c = (Ejerciciosexternos) queryObj.getSingleResult();
        return c;
    }
    
    public String createNewEjerExternos(Ejerciciosexternos e) {
        entityMgrObj.getTransaction().begin();
        entityMgrObj.persist(e);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
        return "newproblem.xhtml?faces-redirect=true";
    }
    
    public String deleteEjerExternos(Ejerciciosexternos e2) {
        FacesMessage message = new FacesMessage();
        try {
            entityMgrObj.getTransaction().begin();
            Ejerciciosexternos e1 = entityMgrObj.find(Ejerciciosexternos.class, e2.getId());
            entityMgrObj.remove(e1);
            entityMgrObj.getTransaction().commit();
            entityMgrObj.close();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado con éxito", "");
        } catch (Exception e) {
        } finally {
        }
        return "newproblem.xhtml?faces-redirect=true";
    }
    
    public String updateEjerExternosDetails(Integer id, String titulo, String judge,
            String judgeid, Integer diff, String type1, String type2, String type3, String type4, String url) {
        entityMgrObj.getTransaction().begin();
        Ejerciciosexternos ee = entityMgrObj.find(Ejerciciosexternos.class, id);
        ee.setTitle(titulo);
        ee.setJudge(judge);
        ee.setJudgeid(judgeid);
        ee.setDifficult(diff);
        ee.setType1(type1);
        ee.setType2(type2);
        ee.setType3(type3);
        ee.setType4(type4);
        ee.setUrl(url);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
        return "newproblem.xhtml?faces-redirect=true";
    }
    
    private int getMaxEjerExternosId() {
        int maxeventoid = 1;
        Query queryObj = entityMgrObj.createQuery("SELECT MAX(e.id)+1 FROM Ejerciciosexternos e");
        if (queryObj.getSingleResult() != null) {
            maxeventoid = (Integer) queryObj.getSingleResult();
        }
        return maxeventoid;
    }
}
