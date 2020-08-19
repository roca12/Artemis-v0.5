package com.artemis.service;

import com.artemis.entities.Visitaspormesanio;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VistasMesAnioService {
    
    final String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
    final EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    
    public void createAnioVisitas() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        entityMgrObj.getTransaction().begin();
        Visitaspormesanio v = new Visitaspormesanio();
        v.setAnio(year);
        v.setEnero(0);
        v.setFebrero(0);
        v.setMarzo(0);
        v.setAbril(0);
        v.setMayo(0);
        v.setJunio(0);
        v.setJulio(0);
        v.setAgosto(0);
        v.setSeptiembre(0);
        v.setOctubre(0);
        v.setNoviembre(0);
        v.setDiciembre(0);
        entityMgrObj.persist(v);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
    }
    
    public void updateVisitas() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        entityMgrObj.getTransaction().begin();
        Query queryObj = entityMgrObj.createQuery("SELECT v FROM Visitaspormesanio v WHERE v.anio=:anio");
        queryObj.setParameter("anio", year);
        Visitaspormesanio v = (Visitaspormesanio) queryObj.getSingleResult();
        switch (month) {
            case 1:
                v.setEnero(v.getEnero() + 1);
                break;
            case 2:
                v.setFebrero(v.getFebrero() + 1);
                break;
            case 3:
                v.setMarzo(v.getMarzo() + 1);
                break;
            case 4:
                v.setAbril(v.getAbril() + 1);
                break;
            case 5:
                v.setMayo(v.getMayo() + 1);
                break;
            case 6:
                v.setJunio(v.getJunio() + 1);
                break;
            case 7:
                v.setJulio(v.getJulio() + 1);
                break;
            case 8:
                v.setAgosto(v.getAgosto() + 1);
                break;
            case 9:
                v.setSeptiembre(v.getSeptiembre() + 1);
                break;
            case 10:
                v.setOctubre(v.getOctubre() + 1);
                break;
            case 11:
                v.setNoviembre(v.getNoviembre() + 1);
                break;
            case 12:
                v.setDiciembre(v.getDiciembre() + 1);
                break;
        }
        entityMgrObj.persist(v);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
    }
    
    public List<Visitaspormesanio> getAll() {
        Query queryObj = entityMgrObj.createQuery("SELECT v FROM Visitaspormesanio v");
        List<Visitaspormesanio> visitList = queryObj.getResultList();
        if (visitList != null && visitList.size() > 0) {
            return visitList;
        } else {
            return null;
        }
    }
    
}
