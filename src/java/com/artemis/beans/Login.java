package com.artemis.beans;

import com.artemis.entities.Cuenta;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private String pwd;
    private int nivel=99;
    private String user;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int validate() {
        final String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
        final EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        Query queryObj = entityMgrObj.createQuery("SELECT c FROM Cuenta c");
        List<Cuenta> list = queryObj.getResultList();
        for (Cuenta c : list) {
            if (c.getUsername().equals(user) && c.getPass().equals(pwd) && c.getRango() == 0) {
                nivel=0;
                return 0;
            } else if (c.getUsername().equals(user) && c.getPass().equals(pwd) && c.getRango() == 5) {
                nivel=5;
                return 5;
            }
        }
        return 99;
    }
    //validate login

    public String validateUsernamePassword() {
        int valid = validate();
        switch (valid) {
            case 0: {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", user);
                nivel=0;
                return "admin";
            }
            case 5: {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", user);
                nivel=5;
                return "index";
            }
            default:
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Nombre de usuario o contraseña incorrecta",
                                "Por favor ingrese dos datos correctos"));
                return "login";
        }
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index";
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
   
}
