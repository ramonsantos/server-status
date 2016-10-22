package ramonsantos.desafio_ustore.service;

import java.io.IOException;
import java.io.InputStream;

public class ServerStatusService implements IServerStatusService {

	public String getUptime() throws IOException {

		StringBuilder saida = new StringBuilder();

		Process child = Runtime.getRuntime().exec("cat /proc/uptime");

		InputStream in = child.getInputStream();
		int c;

		while ((c = in.read()) != -1 && ((char) c != ' ')) {
			saida.append((char) c);
		}
		in.close();

		// TODO - Formatar para uma saída DD:HH:MM:SS
		
		return saida.toString();

	}

	@Override
	public String getOSInfo() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getTotalMemory() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getFreeMemory() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getUsedMemory() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getTotalDisk() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getFreeDisk() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getUsedDisk() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
