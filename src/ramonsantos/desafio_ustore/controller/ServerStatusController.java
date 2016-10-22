package ramonsantos.desafio_ustore.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;

import ramonsantos.desafio_ustore.service.IServerStatusService;
import ramonsantos.desafio_ustore.service.ServerStatusService;

@ManagedBean(name = "serverStatusController")
public class ServerStatusController {

	private IServerStatusService sss;

	public ServerStatusController() {

		sss = new ServerStatusService();

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

}
