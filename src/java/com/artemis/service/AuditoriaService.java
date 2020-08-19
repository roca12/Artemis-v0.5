package com.artemis.service;

import com.artemis.entities.Auditoriaacceso;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AuditoriaService {

    final String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
    final EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();

    public void createAudit(String username, String URL) {
        entityMgrObj.getTransaction().begin();
        Auditoriaacceso aa= new Auditoriaacceso();
        aa.setId(null);
        aa.setFechaentrada(new Date());
        aa.setUsername(username);
        aa.setHosturl(URL);
        entityMgrObj.persist(aa);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
    }

    public List<Auditoriaacceso> getAllAudit() {
        Query queryObj = entityMgrObj.createQuery("SELECT a FROM Auditoriaacceso a");
        List<Auditoriaacceso> auditList = queryObj.getResultList();
        if (auditList != null && auditList.size() > 0) {
            return auditList;
        } else {
            return null;
        }
    }
}
