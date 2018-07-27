package com.edu.storage.util;
/*cfg reader class to read the parameters specified in configfile.json.
 * */
public class CFGReader {

	private String homeDir;
	private String shard1IPAddress;
	private String shard2IPAddress;
	private String shard3IPAddress;
	private String shard1IPAddressShardingServer;
	private String shard2IPAddressShardingServer;
	private String shard3IPAddressShardingServer;
	private int shard1PortNumber;
	private int shard2PortNumber;
	private int shard3PortNumber;
	private int shard1PortNumberShardingServer;
	private int shard2PortNumberShardingServer;
	private int shard3PortNumberShardingServer;
	private String destDir1;
	private String destDir2;
	private String destDir3;
	private String fileName;
	private int numberOfServers;
	private String metadatafile;
	public CFGReader(String homedir, String destdir1,String destdir2,String destdir3, String shard1ipaddress, String shard2ipaddress,
			String shard3ipaddress, int portnumber1, int portnumber2, int portnumber3, String file,int numberofservers,String metaf,
			String shard1ipaddressshardingserver, String shard2ipaddressshardingserver, String shard3ipaddressshardingserver,
			int portnumber1shardingserver, int portnumber2shardingserver, int portnumber3shardingserver) {
		homeDir = homedir;
		shard1IPAddress = shard1ipaddress;
		shard2IPAddress = shard2ipaddress;
		shard3IPAddress = shard3ipaddress;
		shard1IPAddressShardingServer = shard1ipaddressshardingserver;
		shard2IPAddressShardingServer = shard2ipaddressshardingserver;
		shard3IPAddressShardingServer = shard3ipaddressshardingserver;
		shard1PortNumber = portnumber1;
		shard2PortNumber = portnumber2;
		shard3PortNumber = portnumber3;
		shard1PortNumberShardingServer = portnumber1shardingserver;
		shard2PortNumberShardingServer = portnumber2shardingserver;
		shard3PortNumberShardingServer = portnumber3shardingserver;
		destDir1 = destdir1;
		destDir2 = destdir2;
		destDir3 = destdir3;
		fileName = file;
		numberOfServers = numberofservers;
        metadatafile= metaf;
	}

	public String getMetadatafile() {
		return metadatafile;
	}

	public void setMetadatafile(String metadatafile) {
		this.metadatafile = metadatafile;
	}

	/**
	 * @return the destDir1
	 */
	public String getDestDir1() {
		return destDir1;
	}

	/**
	 * @param destDir1 the destDir1 to set
	 */
	public void setDestDir1(String destDir1) {
		this.destDir1 = destDir1;
	}

	/**
	 * @return the destDir2
	 */
	public String getDestDir2() {
		return destDir2;
	}

	/**
	 * @param destDir2 the destDir2 to set
	 */
	public void setDestDir2(String destDir2) {
		this.destDir2 = destDir2;
	}

	/**
	 * @return the destDir3
	 */
	public String getDestDir3() {
		return destDir3;
	}

	/**
	 * @param destDir3 the destDir3 to set
	 */
	public void setDestDir3(String destDir3) {
		this.destDir3 = destDir3;
	}

	/**
	 * @return the homeDir
	 */
	public String getHomeDir() {
		return homeDir;
	}

	/**
	 * @param homeDir the homeDir to set
	 */
	public void setHomeDir(String homeDir) {
		this.homeDir = homeDir;
	}

	/**
	 * @return the shard1IPAddress
	 */
	public String getShard1IPAddress() {
		return shard1IPAddress;
	}

	/**
	 * @param shard1ipAddress the shard1IPAddress to set
	 */
	public void setShard1IPAddress(String shard1ipAddress) {
		shard1IPAddress = shard1ipAddress;
	}

	/**
	 * @return the shard2IPAddress
	 */
	public String getShard2IPAddress() {
		return shard2IPAddress;
	}

	/**
	 * @param shard2ipAddress the shard2IPAddress to set
	 */
	public void setShard2IPAddress(String shard2ipAddress) {
		shard2IPAddress = shard2ipAddress;
	}

	/**
	 * @return the shard3IPAddress
	 */
	public String getShard3IPAddress() {
		return shard3IPAddress;
	}

	/**
	 * @param shard3ipAddress the shard3IPAddress to set
	 */
	public void setShard3IPAddress(String shard3ipAddress) {
		shard3IPAddress = shard3ipAddress;
	}

	/**
	 * @return the shard1PortNumber
	 */
	public int getShard1PortNumber() {
		return shard1PortNumber;
	}

	/**
	 * @param shard1PortNumber the shard1PortNumber to set
	 */
	public void setShard1PortNumber(int shard1PortNumber) {
		this.shard1PortNumber = shard1PortNumber;
	}

	/**
	 * @return the shard2PortNumber
	 */
	public int getShard2PortNumber() {
		return shard2PortNumber;
	}

	/**
	 * @param shard2PortNumber the shard2PortNumber to set
	 */
	public void setShard2PortNumber(int shard2PortNumber) {
		this.shard2PortNumber = shard2PortNumber;
	}

	/**
	 * @return the shard3PortNumber
	 */
	public int getShard3PortNumber() {
		return shard3PortNumber;
	}

	/**
	 * @param shard3PortNumber the shard3PortNumber to set
	 */
	public void setShard3PortNumber(int shard3PortNumber) {
		this.shard3PortNumber = shard3PortNumber;
	}

	

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the numberOfServers
	 */
	public int getNumberOfServers() {
		return numberOfServers;
	}

	/**
	 * @param numberOfServers the numberOfServers to set
	 */
	public void setNumberOfServers(int numberOfServers) {
		this.numberOfServers = numberOfServers;
	}

	/**
	 * @return the shard1IPAddressShardingServer
	 */
	public String getShard1IPAddressShardingServer() {
		return shard1IPAddressShardingServer;
	}

	/**
	 * @param shard1ipAddressShardingServer the shard1IPAddressShardingServer to set
	 */
	public void setShard1IPAddressShardingServer(String shard1ipAddressShardingServer) {
		shard1IPAddressShardingServer = shard1ipAddressShardingServer;
	}

	/**
	 * @return the shard2IPAddressShardingServer
	 */
	public String getShard2IPAddressShardingServer() {
		return shard2IPAddressShardingServer;
	}

	/**
	 * @param shard2ipAddressShardingServer the shard2IPAddressShardingServer to set
	 */
	public void setShard2IPAddressShardingServer(String shard2ipAddressShardingServer) {
		shard2IPAddressShardingServer = shard2ipAddressShardingServer;
	}

	/**
	 * @return the shard3IPAddressShardingServer
	 */
	public String getShard3IPAddressShardingServer() {
		return shard3IPAddressShardingServer;
	}

	/**
	 * @param shard3ipAddressShardingServer the shard3IPAddressShardingServer to set
	 */
	public void setShard3IPAddressShardingServer(String shard3ipAddressShardingServer) {
		shard3IPAddressShardingServer = shard3ipAddressShardingServer;
	}

	/**
	 * @return the shard1PortNumberShardingServer
	 */
	public int getShard1PortNumberShardingServer() {
		return shard1PortNumberShardingServer;
	}

	/**
	 * @param shard1PortNumberShardingServer the shard1PortNumberShardingServer to set
	 */
	public void setShard1PortNumberShardingServer(int shard1PortNumberShardingServer) {
		this.shard1PortNumberShardingServer = shard1PortNumberShardingServer;
	}

	/**
	 * @return the shard2PortNumberShardingServer
	 */
	public int getShard2PortNumberShardingServer() {
		return shard2PortNumberShardingServer;
	}

	/**
	 * @param shard2PortNumberShardingServer the shard2PortNumberShardingServer to set
	 */
	public void setShard2PortNumberShardingServer(int shard2PortNumberShardingServer) {
		this.shard2PortNumberShardingServer = shard2PortNumberShardingServer;
	}

	/**
	 * @return the shard3PortNumberShardingServer
	 */
	public int getShard3PortNumberShardingServer() {
		return shard3PortNumberShardingServer;
	}

	/**
	 * @param shard3PortNumberShardingServer the shard3PortNumberShardingServer to set
	 */
	public void setShard3PortNumberShardingServer(int shard3PortNumberShardingServer) {
		this.shard3PortNumberShardingServer = shard3PortNumberShardingServer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CFGReader [homeDir=" + homeDir + ", shard1IPAddress=" + shard1IPAddress + ", shard2IPAddress="
				+ shard2IPAddress + ", shard3IPAddress=" + shard3IPAddress + ", shard1IPAddressShardingServer="
				+ shard1IPAddressShardingServer + ", shard2IPAddressShardingServer=" + shard2IPAddressShardingServer
				+ ", shard3IPAddressShardingServer=" + shard3IPAddressShardingServer + ", shard1PortNumber="
				+ shard1PortNumber + ", shard2PortNumber=" + shard2PortNumber + ", shard3PortNumber=" + shard3PortNumber
				+ ", shard1PortNumberShardingServer=" + shard1PortNumberShardingServer
				+ ", shard2PortNumberShardingServer=" + shard2PortNumberShardingServer
				+ ", shard3PortNumberShardingServer=" + shard3PortNumberShardingServer + ", destDir1=" + destDir1
				+ ", destDir2=" + destDir2 + ", destDir3=" + destDir3 + ", fileName=" + fileName + ", numberOfServers="
				+ numberOfServers + ", metadatafile=" + metadatafile + "]";
	}

}
