package ramonsantos.server_status.service;

import java.io.IOException;

import ramonsantos.server_status.util.OSDataCollector;

public class ServerStatusService implements IServerStatusService {

	private OSDataCollector osDataCollector;

	public ServerStatusService() {

		this.osDataCollector = new OSDataCollector();

	}

	public String getUptime() throws IOException {

		return this.osDataCollector.getUptime();

	}

	@Override
	public String getOSInfo() throws IOException {

		return this.osDataCollector.getOSInfo();

	}

	public String getKernelInfo() throws IOException {

		return this.osDataCollector.getKernelInfo();

	}

	@Override
	public Integer getTotalMemory() throws IOException {

		return Integer.parseInt(this.osDataCollector.getMemoryInfo()[0]);

	}

	@Override
	public Integer getFreeMemory() throws IOException {

		return Integer.parseInt(this.osDataCollector.getMemoryInfo()[2]);

	}

	@Override
	public Integer getUsedMemory() throws IOException {

		return Integer.parseInt(this.osDataCollector.getMemoryInfo()[1]);

	}

	public Integer getBuffCaheMemory() throws IOException {

		return Integer.parseInt(this.osDataCollector.getMemoryInfo()[3]);

	}

	@Override
	public Integer getTotalDisk() throws IOException {

		return this.getFreeDisk() + this.getUsedDisk();

	}

	@Override
	public Integer getFreeDisk() throws IOException {

		return this.osDataCollector.getFreeSpaceDisk();

	}

	@Override
	public Integer getUsedDisk() throws IOException {

		return this.osDataCollector.getUsedSpaceDisk();

	}

}
