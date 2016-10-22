package ramonsantos.desafio_ustore.service;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;


// TODO - Atribuir ao Controller
@ManagedBean
public class PieChartService implements Serializable {

	private static final long serialVersionUID = 3381484944292509287L;

	private PieChartModel pieModel1;
	private PieChartModel pieModel2;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	private void createPieModels() {
		createPieModel1();
		createPieModel2();
	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		pieModel1.set("Brand 1", 100.0);
		pieModel1.set("Brand 2", 50.0);
		pieModel1.set("Brand 3", 10.0);
		pieModel1.set("Brand 4", 75.0);

		pieModel1.setTitle("Simple Pie");
		pieModel1.setLegendPosition("w");
	}

	private void createPieModel2() {
		pieModel2 = new PieChartModel();

		pieModel2.set("Brand 1", 540);
		pieModel2.set("Brand 2", 325);
		pieModel2.set("Brand 3", 702);
		pieModel2.set("Brand 4", 421);

		pieModel2.setTitle("Custom Pie");
		pieModel2.setLegendPosition("e");
		pieModel2.setFill(false);
		pieModel2.setShowDataLabels(true);
		pieModel2.setDiameter(150);
	}

}