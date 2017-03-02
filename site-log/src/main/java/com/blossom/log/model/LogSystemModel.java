package com.blossom.log.model;

import java.io.Serializable;

/**
 * @Description: 系统日志模型
 * @author Blossom
 * @time 2017年3月2日 下午3:30:24
 */
public class LogSystemModel implements Serializable {

	private static final long serialVersionUID = -4863886365606314113L;
	
	//编号
	private Integer id;
	//类名称
	private String className;
	//方法名称
	private String methodName;
	//操作时间
	private String createTime;
	//日志级别
	private String loglevel;
	//信息
	private String message;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}
	/**
	 * @param methodName the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the loglevel
	 */
	public String getLoglevel() {
		return loglevel;
	}
	/**
	 * @param loglevel the loglevel to set
	 */
	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月2日 下午3:32:53
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LogSystemModel [id=" + id + ", className=" + className + ", methodName=" + methodName + ", createTime="
				+ createTime + ", loglevel=" + loglevel + ", message=" + message + "]";
	}
	
	

}
