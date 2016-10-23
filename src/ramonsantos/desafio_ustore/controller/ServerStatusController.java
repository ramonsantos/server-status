package ramonsantos.desafio_ustore.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import ramonsantos.desafio_ustore.service.IServerStatusService;
import ramonsantos.desafio_ustore.service.PieChartService;
import ramonsantos.desafio_ustore.service.ServerStatusService;

@ManagedBean(name = "serverStatusController")
public class ServerStatusController {

	private IServerStatusService sss;
	private PieChartService pcs;

	public ServerStatusController() {

		sss = new ServerStatusService();
		pcs = new PieChartService();
		pcs.init();

	}

	public String getUptime() {

		try {

			return sss.getUptime();

		} catch (IOException e) {

			e.printStackTrace();

			return "Não disponível!";

		}

	}

	public String getOSInfo() {

		try {

			return sss.getOSInfo();

		} catch (IOException e) {

			e.printStackTrace();

			return "Não disponível!";

		}

	}

	public String getKernelInfo() {

		try {

			return sss.getKernelInfo();

		} catch (IOException e) {

			e.printStackTrace();

			return "Não disponível!";

		}

	}

	public PieChartModel getDiskChartModel() {

		return pcs.getDiskChartModel();

	}

	public PieChartModel getMemoryChartModel() {

		return pcs.getMemoryChartModel();

	}

}
