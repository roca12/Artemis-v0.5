package com.artemis.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "indexViewController")
public class IndexViewController {

    private List<String> images = new ArrayList<>();

    @PostConstruct
    public void init() {
        String listacompleta = "2da interna UNIECCI luego de 2 horas de competencia.jpg\n"
                + "Ambiente competitivo en competencia clasificatoria.jpg\n"
                + "Estudiantes de 10mo grado en su primera competencia.jpg\n"
                + "Estudiantes de 11 compitiendo por primera vez.jpg\n"
                + "Estudiantes de 2do semestre en competencia.jpg\n"
                + "Maratón nacional de programación ACIS-REDIS 2018.jpg\n"
                + "OPENDAY UECCI 2019 - bachilleres en su primera competencia.jpg\n"
                + "Politécnico Grancolombiano en competencia.jpg\n"
                + "Receso pre-resultados Maratón nacional 2018.jpg\n"
                + "Segunda maratón interna bajo reglas ICPC.jpg\n"
                + "Segunda maratón interna UNIECCI.jpg\n"
                + "SENA en competencia.jpg\n"
                + "U. Jorge Tadeo Lozano en competencia.jpg\n"
                + "Universidad ECCI en la Maratón nacional 2018.jpg\n"
                + "Universidad nacional de Colombia en competencia.jpg";

        String[] names = listacompleta.split("\n");
        for (String n : names) {
            images.add(n);
        }

    }

    public String links() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = request.getRequestURL().toString();
        int cont = 0, index = 0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '/') {
                cont++;
            }
            if (cont == 4) {
                index = i;
                break;
            }
        }
        url = url.substring(0, index + 1);
        return url;
    }

    public List<String> getImages() {
        return images;

    }
}
