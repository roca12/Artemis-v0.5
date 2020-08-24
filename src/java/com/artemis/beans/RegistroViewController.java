package com.artemis.beans;

import com.artemis.service.RegistroService;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "registroViewController")
@ConversationScoped
public class RegistroViewController implements Serializable {

    private String primernombre;
    private String primerapellido;
    private String segundonombre;
    private String segundoapellido;
    private String correo;
    private String username;
    private String password;
    private String password2;
    private String rango;
    private final RegistroService registroService = new RegistroService();

    public void crearCuenta() throws SQLException, IOException {
        FacesMessage message = new FacesMessage();
        try {
            registroService.crearCuenta(primernombre, segundonombre, primerapellido, segundoapellido, username, password, correo);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, evalAsString("#{msg['artemis.registro.creado']}"), "");
        } catch (Exception e) {
            System.out.println("Conexión fallida ");
            e.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_FATAL, evalAsString("#{msg['artemis.registro.error']}"), "");
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, message);
            primernombre = null;
            primerapellido = null;
            segundonombre = null;
            segundoapellido = null;
            correo = null;
            username = null;
            password = null;
            password2 = null;
        }
    }

    public void crearCuenta2() throws SQLException, IOException {
        FacesMessage message = new FacesMessage();
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, evalAsString("#{msg['artemis.registro.creado']}"), "");
        try {
            registroService.crearCuenta2(primernombre, segundonombre, primerapellido, segundoapellido, username, password, Integer.parseInt(rango), correo);
        } catch (Exception e) {
            System.out.println("Conexión fallida ");
            e.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_FATAL, evalAsString("#{msg['artemis.registro.error']}"), "");
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, message);
            primernombre = null;
            primerapellido = null;
            segundonombre = null;
            segundoapellido = null;
            correo = null;
            username = null;
            password = null;
            password2 = null;
        }
    }

    public String evalAsString(String p_expression) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExpressionFactory expressionFactory = context.getApplication().getExpressionFactory();
        ELContext elContext = context.getELContext();
        ValueExpression vex = expressionFactory.createValueExpression(elContext, p_expression, String.class
        );
        String result = (String) vex.getValue(elContext);
        return result;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }
}
