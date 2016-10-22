package ramonsantos.desafio_ustore.service;

import java.io.IOException;

public interface IServerStatusService {

	public abstract String getUptime() throws IOException;

	public abstract String getOSInfo() throws IOException;

	public abstract Double getTotalMemory() throws IOException;

	public abstract Double getFreeMemory() throws IOException;

	public abstract Double getUsedMemory() throws IOException;

	public abstract Double getTotalDisk() throws IOException;

	public abstract Double getFreeDisk() throws IOException;

	public abstract Double getUsedDisk() throws IOException;

}
