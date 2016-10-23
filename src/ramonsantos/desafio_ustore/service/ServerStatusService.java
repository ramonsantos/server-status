package ramonsantos.desafio_ustore.service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;

public class ServerStatusService implements IServerStatusService {

	public String getUptime() throws IOException {

		int SEG_IN_DAY = 86400;

		String uptimeOut = this.getOutOSCommand("cat /proc/uptime");
		uptimeOut = uptimeOut.substring(0, uptimeOut.indexOf('.'));

		int timeIn = Integer.parseInt(uptimeOut);

		int segOfDay = timeIn % SEG_IN_DAY;
		int days = timeIn / SEG_IN_DAY;

		LocalTime timeOfDay = LocalTime.ofSecondOfDay(segOfDay);
		String time = timeOfDay.toString();

		return (days + ":" + time);

	}

	@Override
	public String getOSInfo() throws IOException {

		// TODO - Separar kernel de distro

		String osInfo = getOutOSCommand("bash " + this.getPathScript("osInfo.sh"));
		osInfo = osInfo.replaceAll("PRETTY_NAME=", "").replaceAll("\"", "");

		return osInfo;

	}

	@Override
	public Integer getTotalMemory() throws IOException {

		return Integer.parseInt(getMemoryInfo()[0]);

	}

	@Override
	public Integer getFreeMemory() throws IOException {

		return Integer.parseInt(getMemoryInfo()[2]);

	}

	@Override
	public Integer getUsedMemory() throws IOException {

		return Integer.parseInt(getMemoryInfo()[1]);

	}

	public Integer getBuffCaheMemory() throws IOException {

		return Integer.parseInt(getMemoryInfo()[3]);

	}

	@Override
	public Integer getTotalDisk() throws IOException {

		return this.getFreeDisk() + this.getUsedDisk();

	}

	@Override
	public Integer getFreeDisk() throws IOException {

		return getSpaceDisk(this.getPathScript("freeDisk.sh"));

	}

	@Override
	public Integer getUsedDisk() throws IOException {

		return getSpaceDisk(this.getPathScript("usedDisk.sh"));

	}

	private String getOutOSCommand(String command) throws IOException {

		StringBuilder commandOut = new StringBuilder();

		Process child = Runtime.getRuntime().exec(command);

		InputStream in = child.getInputStream();
		int c;

		while ((c = in.read()) != -1) {

			commandOut.append((char) c);

		}

		in.close();

		return commandOut.toString();

	}

	private Integer getSpaceDisk(String script) throws IOException {

		Integer disk = 0;

		String out = getOutOSCommand("bash " + script);

		String array[] = out.split("\n");

		for (int i = 0; i < array.length; i++) {

			disk = disk + Integer.parseInt(array[i]);

		}

		return disk;

	}

	private String[] getMemoryInfo() throws IOException {

		return getOutOSCommand("bash " + this.getPathScript("freeMemory.sh")).replaceAll("\n", "").split(" ");

	}

	private String getPathScript(String nameScript) {

		return getClass().getResource("/" + nameScript).getPath();

	}

}
