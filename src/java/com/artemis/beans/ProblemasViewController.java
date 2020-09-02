package com.artemis.beans;

import com.artemis.entities.Ejerciciosexternos;
import com.artemis.service.ProblemasService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import static org.primefaces.behavior.confirm.ConfirmBehavior.PropertyKeys.message;

@Named(value = "problemasViewController")
@ViewScoped
public class ProblemasViewController implements Serializable {

    private List<Juez> jueces;
    private List<SelectItem> listajueces;
    private String juezselected;
    private String titulonew, judgeidnew, type1new, type2new, type3new, type4new, urlnew;
    private Integer diffnew;
    private Ejerciciosexternos ejercicioextselected;
    private final ProblemasService problemasService = new ProblemasService();

    public ProblemasViewController() {
    }

    @PostConstruct
    public void init() {
        jueces = new ArrayList<>();
        jueces.add(new Juez(0, "codechef.ico", "CodeChef"));
        jueces.add(new Juez(1, "CodeForces.png", "Codeforces"));
        jueces.add(new Juez(2, "hackerrank.png", "HackerRank"));
        jueces.add(new Juez(3, "icpclive.gif", "ICPC Live Archive"));
        jueces.add(new Juez(4, "Kattis.ico", "Kattis Problem Archive"));
        jueces.add(new Juez(5, "SPOJ.png", "Sphere Online Judge"));
        jueces.add(new Juez(6, "topcoder.png", "TopCoder"));
        jueces.add(new Juez(7, "URAL.ico", "Timus Online Judge"));
        jueces.add(new Juez(8, "UVA.ico", "Online Judge (anteriormente UVa Online Judge)"));

        if (listajueces == null) {
            listajueces = new ArrayList<SelectItem>();
            for (Juez cat : jueces) {
                listajueces.add(new SelectItem(cat.getAlias(),cat.getNombrecompleto())); 
            }
        }
    }

    public class Juez {

        Integer id;
        String alias, nombrecompleto;

        public Juez(Integer id, String alias, String nombrecompleto) {
            this.id = id;
            this.alias = alias;
            this.nombrecompleto = nombrecompleto;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getNombrecompleto() {
            return nombrecompleto;
        }

        public void setNombrecompleto(String nombrecompleto) {
            this.nombrecompleto = nombrecompleto;
        }

    }

    public List<Juez> getJueces() {
        return jueces;
    }

    public void setJueces(List<Juez> jueces) {
        this.jueces = jueces;
    }

    

    public String getTitulonew() {
        return titulonew;
    }

    public void setTitulonew(String titulonew) {
        this.titulonew = titulonew;
    }

    public String getJudgeidnew() {
        return judgeidnew;
    }

    public void setJudgeidnew(String judgeidnew) {
        this.judgeidnew = judgeidnew;
    }

    public String getType1new() {
        return type1new;
    }

    public void setType1new(String type1new) {
        this.type1new = type1new;
    }

    public String getType2new() {
        return type2new;
    }

    public void setType2new(String type2new) {
        this.type2new = type2new;
    }

    public String getType3new() {
        return type3new;
    }

    public void setType3new(String type3new) {
        this.type3new = type3new;
    }

    public String getType4new() {
        return type4new;
    }

    public void setType4new(String type4new) {
        this.type4new = type4new;
    }

    public String getUrlnew() {
        return urlnew;
    }

    public void setUrlnew(String urlnew) {
        this.urlnew = urlnew;
    }

    public Integer getDiffnew() {
        return diffnew;
    }

    public void setDiffnew(Integer diffnew) {
        this.diffnew = diffnew;
    }

    public Ejerciciosexternos getEjercicioextselected() {
        return ejercicioextselected;
    }

    public void setEjercicioextselected(Ejerciciosexternos ejercicioextselected) {
        this.ejercicioextselected = ejercicioextselected;
    }

    public List<SelectItem> getListajueces() {
        return listajueces;
    }

    public void setListajueces(List<SelectItem> listajueces) {
        this.listajueces = listajueces;
    }

    public String getJuezselected() {
        return juezselected;
    }

    public void setJuezselected(String juezselected) {
        this.juezselected = juezselected;
    }
    
    

    public String crearejerext() {
        ProblemasService problemasService1 = new ProblemasService();
        Ejerciciosexternos ee = new Ejerciciosexternos();
        ee.setTitle(titulonew);
        ee.setJudge(juezselected.substring(0, juezselected.indexOf(".")));
        ee.setJudgeid(judgeidnew);
        ee.setDifficult(diffnew);
        ee.setType1(type1new);
        ee.setType2(type2new);
        ee.setType3(type3new);
        ee.setType4(type4new);
        ee.setUrl(urlnew);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Creado",  "Campo creado correctamente") );
        return problemasService1.createNewEjerExternos(ee);
        
    }

    public List<Ejerciciosexternos> getejerextList() {
        return problemasService.getAllEjerExternos();
    }

    public String deleteejerextById() {
        return problemasService.deleteEjerExternos(ejercicioextselected);
    }
    

}
