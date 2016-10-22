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
	public Integer getTotalMemory() throws IOException {

		String array[] = getMemoryInfo();

		return Integer.parseInt(array[0]);

	}

	@Override
	public Integer getFreeMemory() throws IOException {

		String array[] = getMemoryInfo();

		return Integer.parseInt(array[1]);

	}

	@Override
	public Integer getUsedMemory() throws IOException {

		return this.getTotalMemory() - this.getFreeMemory();

	}

	@Override
	public Integer getTotalDisk() throws IOException {

		return this.getFreeDisk() + this.getUsedDisk();

	}

	@Override
	public Integer getFreeDisk() throws IOException {

		return getSpaceDisk("freeDisk.sh");

	}

	@Override
	public Integer getUsedDisk() throws IOException {

		return getSpaceDisk("usedDisk.sh");

	}

	private String getOutOSCommand(String command) throws IOException {

		StringBuilder saida = new StringBuilder();

		Process child = Runtime.getRuntime().exec(command);

		InputStream in = child.getInputStream();
		int c;

		while ((c = in.read()) != -1) {

			saida.append((char) c);

		}

		in.close();

		return saida.toString();

	}

	private Integer getSpaceDisk(String script) throws IOException {

		Integer disk = 0;

		// TODO - mudar para caminho relativo
		String out = getOutOSCommand("bash /home/ramonsantos/scripts/" + script);

		String array[] = out.split("\n");

		for (int i = 0; i < array.length; i++) {

			disk = disk + Integer.parseInt(array[i]);

		}

		return disk;

	}

	private String[] getMemoryInfo() throws IOException {

		// TODO - mudar para caminho relativo
		return getOutOSCommand("bash /home/ramonsantos/scripts/" + "freeMemory.sh").replaceAll("\n", "").split(" ");

	}

}
