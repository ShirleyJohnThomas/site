package com.blossom.rq.model;

import java.io.Serializable;

/**
 * @Description: 连接参数模型
 * @author Blossom
 * @time 2017年2月28日 上午11:05:05
 */
public class ParamsModel implements Serializable {

	private static final long serialVersionUID = -1800617405460924886L;
	
	private String host;
	private Integer port;
	private String userName;
	private String password;
	private String virtualHost;
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the virtualHost
	 */
	public String getVirtualHost() {
		return virtualHost;
	}
	/**
	 * @param virtualHost the virtualHost to set
	 */
	public void setVirtualHost(String virtualHost) {
		this.virtualHost = virtualHost;
	}
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年2月28日 上午11:10:07
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParamsModel [host=" + host + ", port=" + port + ", userName=" + userName + ", password=" + password
				+ ", virtualHost=" + virtualHost + "]";
	}
	
	

}
