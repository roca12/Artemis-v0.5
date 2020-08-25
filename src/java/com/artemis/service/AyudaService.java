package com.artemis.service;

import com.artemis.entities.Archivoayuda;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AyudaService {

    final String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
    final EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();

    public List<Archivoayuda> getAllFiles() {
        if (!entityMgrObj.isOpen()) {
            entityMgrObj.getTransaction().begin();
            Query queryObj = entityMgrObj.createQuery("SELECT a FROM Archivoayuda a");
            List<Archivoayuda> filelist = queryObj.getResultList();
            entityMgrObj.close();
            if (filelist != null && filelist.size() > 0) {
                return filelist;
            } else {
                return null;
            }
        }
        Query queryObj = entityMgrObj.createQuery("SELECT a FROM Archivoayuda a");
        List<Archivoayuda> filelist = queryObj.getResultList();
        if (filelist != null && filelist.size() > 0) {
            return filelist;
        } else {
            return null;
        }
    }

    public Archivoayuda getFile(Integer id) {
        Query queryObj = entityMgrObj.createQuery("SELECT a FROM Archivoayuda a WHERE a.id=:id");
        queryObj.setParameter("id", id);
        Archivoayuda a = (Archivoayuda) queryObj.getSingleResult();
        return a;
    }

    public void createNewFile(String filename, byte[] filecontent, String ext, String desc) {
        entityMgrObj.getTransaction().begin();
        Archivoayuda aa = new Archivoayuda();
        aa.setId(getMaxFileId());
        aa.setFileName(filename);
        aa.setFileData(filecontent);
        aa.setFileExtension(ext);
        aa.setDescription(desc);
        entityMgrObj.persist(aa);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
    }

    public void deleteFile(Archivoayuda aa) {
        FacesMessage message = new FacesMessage();
        entityMgrObj.getTransaction().begin();
        Archivoayuda e1 = entityMgrObj.find(Archivoayuda.class, aa.getId());
        entityMgrObj.remove(e1);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado con éxito", "");
 
    }

    private long getMaxFileId() {
        long maxeventoid = 1;
        Query queryObj = entityMgrObj.createQuery("SELECT MAX(a.id)+1 FROM Archivoayuda a");
        if (queryObj.getSingleResult() != null) {
            maxeventoid = (Long) queryObj.getSingleResult();
        }
        return maxeventoid;
    }
}
