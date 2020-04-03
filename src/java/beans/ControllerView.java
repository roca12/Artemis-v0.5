package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "controllerView")
public class ControllerView implements Serializable {


    private String currentTestValue = "";

    private String currentTestedValue = "No hay dato aun";

    public void listener() {
	currentTestedValue = currentTestValue;
	System.out.println("Activado");
    }

    public String getCurrentTestValue() {
	return currentTestValue;
    }

    public void setCurrentTestValue(String currentTestValue) {
	this.currentTestValue = currentTestValue;
    }

    public String getCurrentTestedValue() {
	return currentTestedValue;
    }

    public void setCurrentTestedValue(String currentTestedValue) {
	this.currentTestedValue = currentTestedValue;
    }

}