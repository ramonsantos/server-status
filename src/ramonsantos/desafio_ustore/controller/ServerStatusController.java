package ramonsantos.desafio_ustore.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;

import ramonsantos.desafio_ustore.service.IServerStatusService;
import ramonsantos.desafio_ustore.service.ServerStatusService;

@ManagedBean(name = "serverStatusController")
public class ServerStatusController {

	private IServerStatusService sss;

	public ServerStatusController() {

		try {
			sss = new ServerStatusService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getUptime() {

		try {

			return sss.getUptime();

		} catch (IOException e) {

			// TODO - Mudar para outra msg "nao disponivel"
			e.printStackTrace();
			return "Erro!";

		}

	}

	public Integer getFreeDisk() {

		try {
			return sss.getFreeDisk();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return -1;
		}

	}

}
