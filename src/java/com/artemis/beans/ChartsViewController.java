package com.artemis.beans;

import com.artemis.entities.Cuenta;
import com.artemis.entities.Visitaspormesanio;
import com.artemis.service.CuentaService;
import com.artemis.service.VistasMesAnioService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;

@ManagedBean(name = "chartsViewController")
public class ChartsViewController implements Serializable {

    private DonutChartModel donutModel;
    private BarChartModel barModel;
    private final CuentaService cuentaService = new CuentaService();
    private final VistasMesAnioService vistasMesAnioService = new VistasMesAnioService();

    @PostConstruct
    public void init() {
        loadChartRangos();
        loadChartVisitasMesAnio();

    }

    public void loadChartRangos() {
        donutModel = new DonutChartModel();
        ChartData data = new ChartData();
        DonutChartDataSet dataSet = new DonutChartDataSet();
        List<Cuenta> listacuentas = cuentaService.getAllCuentaDetails();
        Integer estudiantes = 0, administradores = 0, profesores = 0, otros = 0;
        for (Cuenta c : listacuentas) {
            switch (c.getRango()) {
                case 0:
                    administradores++;
                    break;
                case 5:
                    estudiantes++;
                    break;
                case 10:
                    profesores++;
                default:
                    otros++;
                    break;
            }
        }
        List< Number> values = new ArrayList<>();
        values.add(administradores);
        values.add(estudiantes);
        values.add(profesores);
        values.add(otros);
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        bgColors.add("rgb(16, 128, 33)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Administradores");
        labels.add("Estudiantes");
        labels.add("Profesores");
        labels.add("Otros");
        data.setLabels(labels);

        donutModel.setData(data);
    }

    public void loadChartVisitasMesAnio() {
        barModel = new BarChartModel();
        ChartData data = new ChartData();
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Accesos correctos");
        List<Number> values2 = new ArrayList<>();
        List<Visitaspormesanio> list = vistasMesAnioService.getAll();
        Visitaspormesanio anioactual = new Visitaspormesanio();
        for (Visitaspormesanio vpm : list) {
            if (vpm.getAnio() == Calendar.getInstance().get(Calendar.YEAR)) {
                anioactual = vpm;
            }
        }
        values2.add(anioactual.getEnero());
        values2.add(anioactual.getFebrero());
        values2.add(anioactual.getMarzo());
        values2.add(anioactual.getAbril());
        values2.add(anioactual.getMayo());
        values2.add(anioactual.getJunio());
        values2.add(anioactual.getJulio());
        values2.add(anioactual.getAgosto());
        values2.add(anioactual.getSeptiembre());
        values2.add(anioactual.getOctubre());
        values2.add(anioactual.getNoviembre());
        values2.add(anioactual.getDiciembre());

        barDataSet.setData(values2);

        List<String> bgColor2 = new ArrayList<>();
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");
        bgColor2.add("rgba(16, 128, 33, 0.2)");

        barDataSet.setBackgroundColor(bgColor2);

        List<String> borderColor2 = new ArrayList<>();
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        borderColor2.add("rgb(54, 162, 235)");
        barDataSet.setBorderColor(borderColor2);
        barDataSet.setBorderWidth(2);

        data.addChartDataSet(barDataSet);

        List<String> labels2 = new ArrayList<>();
        labels2.add("Enero");
        labels2.add("Febrero");
        labels2.add("Marzo");
        labels2.add("Abril");
        labels2.add("Mayo");
        labels2.add("Junio");
        labels2.add("Julio");
        labels2.add("Agosto");
        labels2.add("Septiembre");
        labels2.add("Octubre");
        labels2.add("Noviembre");
        labels2.add("Diciembre");
        data.setLabels(labels2);

        //Data
        barModel.setData(data);
    }

    public DonutChartModel getDonutModel() {
        return donutModel;
    }

    public void setDonutModel(DonutChartModel donutModel) {
        this.donutModel = donutModel;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

}
