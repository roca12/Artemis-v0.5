package com.artemis.service;

import com.artemis.entities.Cuenta;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RegistroService {

    final String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
    final EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();

    public void crearCuenta(String nombre1, String nombre2, String ap1, String ap2, String username, String password, String correo) {
        entityMgrObj.getTransaction().begin();;
        Cuenta c = new Cuenta();
        c.setId(getMaxCuentaId());
        c.setPrimernombre(nombre1);
        c.setSegundonombre(nombre2);
        c.setPrimerapellido(ap1);
        c.setSegundoapellido(ap2);
        c.setUsername(username);
        c.setPass(password);
        c.setRango(5);
        c.setCorreo(correo);
        entityMgrObj.persist(c);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
    }
    public void crearCuenta2(String nombre1, String nombre2, String ap1, String ap2, String username, String password,Integer rank, String correo) {
        entityMgrObj.getTransaction().begin();;
        Cuenta c = new Cuenta();
        c.setId(getMaxCuentaId());
        c.setPrimernombre(nombre1);
        c.setSegundonombre(nombre2);
        c.setPrimerapellido(ap1);
        c.setSegundoapellido(ap2);
        c.setUsername(username);
        c.setPass(password);
        c.setRango(rank);
        c.setCorreo(correo);
        entityMgrObj.persist(c);
        entityMgrObj.getTransaction().commit();
        entityMgrObj.close();
    }
    private int getMaxCuentaId() {
        int maxcuentaid = 1;
        Query queryObj = entityMgrObj.createQuery("SELECT MAX(c.id)+1 FROM Cuenta c");
        if (queryObj.getSingleResult() != null) {
            maxcuentaid = (Integer) queryObj.getSingleResult();
        }
        return maxcuentaid;
    }

}
