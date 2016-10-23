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

	public String getInfoOS() {

		try {

			return sss.getOSInfo();

		} catch (IOException e) {

			e.printStackTrace();

			return "Não disponível!";

		}

	}

	public Integer getFreeDisk() {

		try {

			return sss.getFreeDisk();

		} catch (IOException e) {

			e.printStackTrace();

			return -1;

		}

	}

	public Integer getUsedDisk() {

		try {

			return sss.getUsedDisk();

		} catch (IOException e) {

			e.printStackTrace();

			return -1;

		}

	}

	public Integer getTotalDisk() {

		try {

			return sss.getTotalDisk();

		} catch (IOException e) {

			e.printStackTrace();

			return -1;

		}

	}

	public PieChartModel getDiskChartModel() {

		return pcs.getDiskChartModel();

	}

	public PieChartModel getMemoryChartModel() {

		return pcs.getMemoryChartModel();

	}

}
