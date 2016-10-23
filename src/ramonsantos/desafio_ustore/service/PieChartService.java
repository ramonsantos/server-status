package ramonsantos.desafio_ustore.service;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.io.Serializable;

import org.primefaces.model.chart.PieChartModel;

public class PieChartService implements Serializable {

	private static final long serialVersionUID = 3381484944292509287L;

	private PieChartModel memoryChart;
	private PieChartModel diskChart;
	private ServerStatusService sss;

	@PostConstruct
	public void init() {

		try {

			sss = new ServerStatusService();
			createPieModels();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public PieChartModel getMemoryChartModel() {

		return memoryChart;

	}

	public PieChartModel getDiskChartModel() {

		return diskChart;

	}

	private void createPieModels() throws IOException {

		createMemoryChart();
		createDiskChart();

	}

	private void createMemoryChart() throws IOException {

		memoryChart = new PieChartModel();

		memoryChart.set("Livre", sss.getFreeMemory());
		memoryChart.set("Usado", sss.getUsedMemory());
		memoryChart.set("Buff/Cache", sss.getBuffCaheMemory());

		memoryChart.setTitle("Memória RAM");
		memoryChart.setLegendPosition("w");
		memoryChart.setShowDataLabels(true);

	}

	private void createDiskChart() throws IOException {

		diskChart = new PieChartModel();

		diskChart.set("Espaço Livre", sss.getFreeDisk());
		diskChart.set("Espaço Usado", sss.getUsedDisk());

		diskChart.setTitle("Disco Rígido");
		diskChart.setLegendPosition("w");
		diskChart.setShowDataLabels(true);

	}

}