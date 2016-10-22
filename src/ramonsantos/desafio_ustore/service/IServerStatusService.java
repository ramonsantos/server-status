package ramonsantos.desafio_ustore.service;

import java.io.IOException;

public interface IServerStatusService {

	public abstract String getUptime() throws IOException;

	public abstract String getOSInfo() throws IOException;

	public abstract Integer getTotalMemory() throws IOException;

	public abstract Integer getFreeMemory() throws IOException;

	public abstract Integer getUsedMemory() throws IOException;

	public abstract Integer getTotalDisk() throws IOException;

	public abstract Integer getFreeDisk() throws IOException;

	public abstract Integer getUsedDisk() throws IOException;

}
