package ramonsantos.desafio_ustore.service;

import java.io.IOException;
import java.io.InputStream;

public class ServerStatusService implements IServerStatusService {

	private Integer diskFree = 0;
	private Integer diskUsed = 0;

	public ServerStatusService() throws IOException {

		this.readDisk();

	}

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
	public Integer getTotalDisk() throws IOException {

		return this.diskFree + this.diskUsed;

	}

	@Override
	public Integer getFreeDisk() throws IOException {

		return this.diskFree;

	}

	@Override
	public Integer getUsedDisk() throws IOException {

		return this.diskUsed;

	}

	private String getOutOSCommand(String command) throws IOException {

		StringBuilder saida = new StringBuilder();

		Process child = Runtime.getRuntime().exec(command);

		InputStream in = child.getInputStream();
		int c;

		while ((c = in.read()) != -1) {

			if ((char) c == ' ') {

				if (!(saida.charAt(saida.length() - 1) == ' ')) {

					saida.append((char) c);
				}

			} else {

				saida.append((char) c);
			}

		}

		in.close();

		return saida.toString().replaceAll("\t", "");

	}

	private void readDisk() throws IOException {

		String[] lines = this.getOutOSCommand("df").split("\n");

		for (int i = 1; i < lines.length; i++) {

			String[] arrayS = lines[i].split(" ");

			this.diskUsed = this.diskUsed + Integer.parseInt(arrayS[2]);
			this.diskFree = this.diskFree + Integer.parseInt(arrayS[3]);

		}

	}

}
