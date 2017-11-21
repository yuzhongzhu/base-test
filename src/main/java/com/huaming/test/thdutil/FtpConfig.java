package com.huaming.test.thdutil;

/**
 * FtpConfig
 * 
 * @author hb
 *
 */
public class FtpConfig {

	private String serverName;
	private int port = 21;
	private String userName;
	private String password;
	
	
	private  String fgjSftpHost;
	private  String fgjSftpPort;
	private  String fgjSftpUser;
	private  String fgjSftpPwd;
	private  String fgjSftpBasePath;
	private  String fgjSftpRootdirName;
	
	
	
	
	public FtpConfig() {
		super();
	}

	public FtpConfig(String serverName, String userName, String password) {
		super();
		this.serverName = serverName;
		this.userName = userName;
		this.password = password;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public  String getFgjSftpHost() {
		return fgjSftpHost;
	}

	public String getFgjSftpPort() {
		return fgjSftpPort;
	}

	public void setFgjSftpPort(String fgjSftpPort) {
		this.fgjSftpPort = fgjSftpPort;
	}

	public String getFgjSftpUser() {
		return fgjSftpUser;
	}

	public void setFgjSftpUser(String fgjSftpUser) {
		this.fgjSftpUser = fgjSftpUser;
	}

	public String getFgjSftpPwd() {
		return fgjSftpPwd;
	}

	public void setFgjSftpPwd(String fgjSftpPwd) {
		this.fgjSftpPwd = fgjSftpPwd;
	}

	public String getFgjSftpBasePath() {
		return fgjSftpBasePath;
	}

	public void setFgjSftpBasePath(String fgjSftpBasePath) {
		this.fgjSftpBasePath = fgjSftpBasePath;
	}

	public String getFgjSftpRootdirName() {
		return fgjSftpRootdirName;
	}

	public void setFgjSftpRootdirName(String fgjSftpRootdirName) {
		this.fgjSftpRootdirName = fgjSftpRootdirName;
	}

	public void setFgjSftpHost(String fgjSftpHost) {
		this.fgjSftpHost = fgjSftpHost;
	}

	
}
