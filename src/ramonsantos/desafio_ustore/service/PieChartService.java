package ramonsantos.desafio_ustore.service;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

// TODO - Atribuir ao Controller
@ManagedBean
public class PieChartService implements Serializable {

	private static final long serialVersionUID = 3381484944292509287L;

	private PieChartModel pieModel1;
	private PieChartModel diskChart;
	ServerStatusService sss;

	@PostConstruct
	public void init() {

		try {

			sss = new ServerStatusService();
			createPieModels();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public PieChartModel getDiskChartModel() {
		return diskChart;
	}

	private void createPieModels() throws IOException {

		createPieModel1();
		createDiskChart();

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

	private void createDiskChart() throws IOException {

		diskChart = new PieChartModel();

		diskChart.set("Espaço Livre", sss.getFreeDisk());
		diskChart.set("Espaço Usado", sss.getUsedDisk());

		diskChart.setTitle("Disco Rígido");
		diskChart.setLegendPosition("w");
		diskChart.setFill(true);
		diskChart.setShowDataLabels(true);

	}

}