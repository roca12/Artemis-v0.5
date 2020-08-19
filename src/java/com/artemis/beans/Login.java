package com.artemis.beans;

import com.artemis.entities.Cuenta;
import com.artemis.service.AuditoriaService;
import com.artemis.service.VistasMesAnioService;
import java.io.Serializable;
import java.util.List;
import java.util.StringTokenizer;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private String pwd;
    private int nivel = 99;
    private String user;
    private final AuditoriaService auditoriaService = new AuditoriaService();
    private final VistasMesAnioService vistasMesAnioService = new VistasMesAnioService();

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

    public static String getClientIpAddress(HttpServletRequest request) {
        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        if (xForwardedForHeader == null) {
            return request.getRemoteAddr();
        } else {
            // As of https://en.wikipedia.org/wiki/X-Forwarded-For
            // The general format of the field is: X-Forwarded-For: client, proxy1, proxy2 ...
            // we only want the client
            return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
        }
    }

    public int validate() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = getClientIpAddress(request);
        final String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
        final EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        Query queryObj = entityMgrObj.createQuery("SELECT c FROM Cuenta c");
        List<Cuenta> list = queryObj.getResultList();
        for (Cuenta c : list) {
            if (c.getUsername().equals(user) && c.getPass().equals(pwd) && c.getRango() == 0) {
                nivel = 0;
                auditoriaService.createAudit(c.getUsername(), url);
                try {
                    vistasMesAnioService.updateVisitas();
                } catch (Exception e) {
                    vistasMesAnioService.createAnioVisitas();
                    vistasMesAnioService.updateVisitas();
                }

                return 0;
            } else if (c.getUsername().equals(user) && c.getPass().equals(pwd) && c.getRango() == 5) {
                nivel = 5;
                auditoriaService.createAudit(c.getUsername(), url);
                auditoriaService.createAudit(c.getUsername(), url);
                try {
                    vistasMesAnioService.updateVisitas();
                } catch (Exception e) {
                    vistasMesAnioService.createAnioVisitas();
                    vistasMesAnioService.updateVisitas();
                }
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
                nivel = 0;
                return "admin";
            }
            case 5: {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", user);
                nivel = 5;
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
