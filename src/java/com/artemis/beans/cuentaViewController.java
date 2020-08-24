package com.artemis.beans;

import com.artemis.entities.Cuenta;
import com.artemis.service.CuentaService;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cuentaViewController")
@ViewScoped
public class cuentaViewController implements Serializable {

    private Integer id;
    private Integer selectedRow;
    private Cuenta cuentaSeleccionada, cuentaEditable;
    private Integer editCuentaId;
    private String primernombre;
    private String segundonombre;
    private String primerapellido;
    private String segundoapellido;
    private String username;
    private String pass;
    private Integer rango;
    private String correo;
    private List<Cuenta> filteredCuentas;
    CuentaService cuentaService = new CuentaService();

    public Integer getId() {
        return id;
    }

    public Integer getEditCuentaId() {
        return editCuentaId;
    }

    public void setEditCuentaId(Integer editCuentaId) {
        this.editCuentaId = editCuentaId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getRango() {
        return rango;
    }

    public void setRango(Integer rango) {
        this.rango = rango;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Cuenta> getFilteredCuentas() {
        return filteredCuentas;
    }

    public void setFilteredCuentas(List<Cuenta> filteredCuentas) {
        this.filteredCuentas = filteredCuentas;
    }

    public CuentaService getCuentaService() {
        return cuentaService;
    }

    public Integer getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(Integer selectedRow) {
        this.selectedRow = selectedRow;
    }

    public Cuenta getCuentaSeleccionada() {
        return cuentaSeleccionada;
    }

    public void setCuentaSeleccionada(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
    }

    public void setCuentaService(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    public Cuenta getCuentaEditable() {
        return cuentaEditable;
    }

    public void setCuentaEditable(Cuenta cuentaEditable) {
        this.cuentaEditable = cuentaEditable;
    }
    //_______________________________________________//

    public List<Cuenta> cuentaListFromDb() {
        return cuentaService.getAllCuentaDetails();
    }

    public String deleteCuentaById() {
        return cuentaService.deleteCuentaDetails(cuentaSeleccionada);
    }

    public String actualizarCuenta() {
        String n1 = cuentaSeleccionada.getPrimernombre();
        String n2 = cuentaSeleccionada.getSegundonombre();
        String a1 = cuentaSeleccionada.getPrimerapellido();
        String a2 = cuentaSeleccionada.getSegundoapellido();
        String username1 = cuentaSeleccionada.getUsername();
        String pass1 = cuentaSeleccionada.getPass();
        Integer rango1 = cuentaSeleccionada.getRango();
        String correo1 = cuentaSeleccionada.getCorreo();
        return cuentaService.updateCuentaDetails(cuentaSeleccionada.getId(),n1,n2,a1, a2, username1, pass1, rango1, correo1);
    }

    public boolean filterPrimerNombre(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }
        Cuenta cuenta = (Cuenta) value;
        return cuenta.getPrimernombre().contains(filterText);
    }

    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        int filterInt = getInteger(filterText);

        Cuenta cuenta = (Cuenta) value;
        return cuenta.getId() < filterInt
                || cuenta.getPrimernombre().contains(filterText)
                || cuenta.getSegundonombre().contains(filterText)
                || cuenta.getPrimerapellido().contains(filterText)
                || cuenta.getSegundoapellido().contains(filterText)
                || cuenta.getUsername().contains(filterText)
                || cuenta.getCorreo().contains(filterText);
    }

    private int getInteger(String string) {
        try {
            return Integer.valueOf(string);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
