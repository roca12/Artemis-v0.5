package com.artemis.service;

import com.artemis.entities.Cuenta;
import com.artemis.util.AES;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CuentaService {

    public List<Cuenta> getAllCuentaDetails() {
        String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
        EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        Query queryObj = entityMgrObj.createQuery("SELECT c FROM Cuenta c");
        List<Cuenta> cuentaList = queryObj.getResultList();
        if (cuentaList != null && cuentaList.size() > 0) {
            return cuentaList;
        } else {
            return null;
        }
    }

    public Cuenta getCuenta(Integer id) {
        String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
        EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        Query queryObj = entityMgrObj.createQuery("SELECT c FROM Cuenta c WHERE c.id=:id");
        queryObj.setParameter("id", id);
        Cuenta c = (Cuenta) queryObj.getSingleResult();
        return c;
    }

    public Cuenta getCuentaByUser(String user) {
        String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
        EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        Query queryObj = entityMgrObj.createQuery("SELECT c FROM Cuenta c WHERE c.username=:user");
        queryObj.setParameter("user", user);
        Cuenta c = new Cuenta();
        try {
            c = (Cuenta) queryObj.getSingleResult();
            return c;
        } catch (Exception e) {
            System.out.println(queryObj);
        }
        return c;
    }

    public String createNewCuenta(String nombre1, String nombre2, String ap1, String ap2, String username, String password, Integer rank, String correo) {
        String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
        EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        entityMgrObj.getTransaction().begin();
        Cuenta c = new Cuenta();
        c.setId(getMaxCuentaId());
        c.setPrimernombre(nombre1);
        c.setSegundonombre(nombre2);
        c.setPrimerapellido(ap1);
        c.setSegundoapellido(ap2);
        c.setUsername(username);
        c.setPass(AES.encrypt(password, AES.KEYART));
        c.setRango(rank);
        c.setCorreo(correo);
        entityMgrObj.persist(c);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
        return "usersadmin.xhtml?faces-redirect=true";
    }

    public String deleteCuentaDetails(Cuenta c) {
        String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
        EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        FacesMessage message = new FacesMessage();
        try {
            entityMgrObj.getTransaction().begin();
            Cuenta c1 = entityMgrObj.find(Cuenta.class, c.getId());
            entityMgrObj.remove(c1);
            entityMgrObj.getTransaction().commit();
            entityMgrObj.close();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado con éxito", "");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo eliminar la cuenta", "");
            return "usersadmin.xhtml?faces-redirect=true";
        }
        return "usersadmin.xhtml?faces-redirect=true";

    }

    public String updateCuentaDetails(int cuentaId, String nombre1, String nombre2, String ap1, String ap2, String username, String password, Integer rank, String correo) {
        String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
        EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        entityMgrObj.getTransaction().begin();
        Cuenta c = entityMgrObj.find(Cuenta.class, cuentaId);
        c.setPrimernombre(nombre1);
        c.setSegundonombre(nombre2);
        c.setPrimerapellido(ap1);
        c.setSegundoapellido(ap2);
        c.setUsername(username);
        if (!password.equals("")) {
            c.setPass(AES.encrypt(password, AES.KEYART));
        }
        c.setRango(rank);
        c.setCorreo(correo);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
        return "useradmin.xhtml?faces-redirect=true";
    }

    private int getMaxCuentaId() {
        String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
        EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        int maxcuentaid = 1;
        Query queryObj = entityMgrObj.createQuery("SELECT MAX(c.id)+1 FROM Cuenta c");
        if (queryObj.getSingleResult() != null) {
            maxcuentaid = (Integer) queryObj.getSingleResult();
        }
        return maxcuentaid;
    }
}
