package com.artemis.beans;

import com.artemis.codes.Especiales.CodesEspeciales;
import com.artemis.codes.basico.CodesBasico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name = "codemirror")
@ViewScoped
public class CodeMirrorController implements Serializable {

    //config del codemirror
    private String theme = "eclipse";
    public List<String> getThemes() {
        final List<String> results = new ArrayList<>();
        results.add("3024-day");
        results.add("3024-night");
        results.add("abcdef");
        results.add("ambiance");
        results.add("ambiance-mobile");
        results.add("base16-dark");
        results.add("base16-light");
        results.add("bespin");
        results.add("blackboard");
        results.add("cobalt");
        results.add("colorforth");
        results.add("dracula");
        results.add("eclipse");
        results.add("elegant");
        results.add("erlang-dark");
        results.add("hopscotch");
        results.add("icecoder");
        results.add("isotope");
        results.add("lesser-dark");
        results.add("liquibyte");
        results.add("material");
        results.add("mbo");
        results.add("mdn-like");
        results.add("midnight");
        results.add("monokai");
        results.add("neat");
        results.add("neo");
        results.add("night");
        results.add("panda-syntax");
        results.add("paraiso-dark");
        results.add("paraiso-light");
        results.add("pastel-on-dark");
        results.add("railscasts");
        results.add("rubyblue");
        results.add("seti");
        results.add("solarized");
        results.add("the-matrix");
        results.add("tomorrow-night-bright");
        results.add("tomorrow-night-eighties");
        results.add("ttcn");
        results.add("twilight");
        results.add("vibrant-ink");
        results.add("xq-dark");
        results.add("xq-light");
        results.add("yeti");
        results.add("zenburn");
        Collections.sort(results);
        return results;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    

    //basico
    private String ciclosjava = CodesBasico.ciclosjava;
    private String cicloscpp = CodesBasico.cicloscpp;
    private String ciclospy = CodesBasico.ciclospy;
    private String lecturaimpresionjava=CodesBasico.lecturaimpresionjava;
    private String lecturaimpresioncpp=CodesBasico.lecturaimpresioncpp;
    private String lecturaimpresionpoy=CodesBasico.lecturaimpresionpy;
    private String excepcionesjava=CodesBasico.excepcionesjava;
    private String excepcionescpp=CodesBasico.excepcionescpp;
    private String excepcionespy=CodesBasico.excepcionespy;

    //especiales
    private String javafastreader = CodesEspeciales.javafastreader;
    private String javaultrareader = CodesEspeciales.javaultrareader;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArtemiswarPU");
    private String cppcinoptimized = CodesEspeciales.cppcinoptimizado;
    private String cppfastscan = CodesEspeciales.cppfastscan;
    private String pyfastinout = CodesEspeciales.pyfastinout;
    private String pynummismalinea = CodesEspeciales.pynummismalinea;
    
    //bitwise
    
    
    //busquedas
    
    
    //dpotros
    
    
    //estructuras
    
    
    //geometria
    
    
    //grafos
    
    
    //matematicas
    
    
    //ordenamiento
    
    
    //strings
    
    
    //sin clasificar
  
    // getters y setters 
    public String getCiclosjava() {
        return ciclosjava;
    }

    public void setCiclosjava(String ciclosjava) {
        this.ciclosjava = ciclosjava;
    }

    public String getCicloscpp() {
        return cicloscpp;
    }

    public void setCicloscpp(String cicloscpp) {
        this.cicloscpp = cicloscpp;
    }

    public String getCiclospy() {
        return ciclospy;
    }

    public void setCiclospy(String ciclospy) {
        this.ciclospy = ciclospy;
    }

    public String getLecturaimpresionjava() {
        return lecturaimpresionjava;
    }

    public void setLecturaimpresionjava(String lecturaimpresionjava) {
        this.lecturaimpresionjava = lecturaimpresionjava;
    }

    public String getLecturaimpresioncpp() {
        return lecturaimpresioncpp;
    }

    public void setLecturaimpresioncpp(String lecturaimpresioncpp) {
        this.lecturaimpresioncpp = lecturaimpresioncpp;
    }

    public String getLecturaimpresionpoy() {
        return lecturaimpresionpoy;
    }

    public void setLecturaimpresionpoy(String lecturaimpresionpoy) {
        this.lecturaimpresionpoy = lecturaimpresionpoy;
    }

    public String getExcepcionesjava() {
        return excepcionesjava;
    }

    public void setExcepcionesjava(String excepcionesjava) {
        this.excepcionesjava = excepcionesjava;
    }

    public String getExcepcionescpp() {
        return excepcionescpp;
    }

    public void setExcepcionescpp(String excepcionescpp) {
        this.excepcionescpp = excepcionescpp;
    }

    public String getExcepcionespy() {
        return excepcionespy;
    }

    public void setExcepcionespy(String excepcionespy) {
        this.excepcionespy = excepcionespy;
    }

    public String getJavafastreader() {
        return javafastreader;
    }

    public void setJavafastreader(String javafastreader) {
        this.javafastreader = javafastreader;
    }

    public String getJavaultrareader() {
        return javaultrareader;
    }

    public void setJavaultrareader(String javaultrareader) {
        this.javaultrareader = javaultrareader;
    }

    public String getCppcinoptimized() {
        return cppcinoptimized;
    }

    public void setCppcinoptimized(String cppcinoptimized) {
        this.cppcinoptimized = cppcinoptimized;
    }

    public String getCppfastscan() {
        return cppfastscan;
    }

    public void setCppfastscan(String cppfastscan) {
        this.cppfastscan = cppfastscan;
    }

    public String getPyfastinout() {
        return pyfastinout;
    }

    public void setPyfastinout(String pyfastinout) {
        this.pyfastinout = pyfastinout;
    }

    public String getPynummismalinea() {
        return pynummismalinea;
    }

    public void setPynummismalinea(String pynummismalinea) {
        this.pynummismalinea = pynummismalinea;
    }

}
