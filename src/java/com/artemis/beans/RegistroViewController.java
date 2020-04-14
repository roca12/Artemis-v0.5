package com.artemis.beans;

import com.artemis.entities.Cuenta;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

    public void crearCuenta() throws SQLException, IOException {
        FacesMessage message = new FacesMessage();

        Connection c = null;
        String URL = "jdbc:mysql://localhost:3306/Artemis?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String USER = "root";
        String PASSWORD = "piroloco2112";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Controlador detectado");
            System.out.println("Conectando...");
            c = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
            PreparedStatement ps = null;
            if (c != null) {
                String sql = "insert into cuentas values (null,?,?,?,?,?,?,5,?);";
                ps = c.prepareStatement(sql);
                ps.setString(1, primernombre);
                ps.setString(2, segundonombre);
                ps.setString(3, primerapellido);
                ps.setString(4, segundoapellido);
                ps.setString(5, username);
                ps.setString(6, password);
                ps.setString(7, correo);
                ps.execute();
                System.out.println("Data Added Successfully");
            }
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, evalAsString("#{msg['artemis.registro.creado']}"), "");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexión fallida ");
            e.printStackTrace();
            message = new FacesMessage(FacesMessage.SEVERITY_FATAL, evalAsString("#{msg['artemis.registro.error']}"), "");
        } finally {
            if (c != null) {
                c.close();
            }
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

}
