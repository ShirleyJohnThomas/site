package com.blossom.redis.model;

import java.io.Serializable;

/**
 * @Description: 消息实体模型
 * @author Blossom
 * @time 2017年2月28日 下午5:23:24
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 2593003811853143435L;
	private Integer id;
	private String content;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年2月28日 下午5:24:20
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + "]";
	}
	/**
	 * @author Blossom
	 * @time 2017年2月28日 下午5:24:28
	 * @param id
	 * @param content
	 */
	public Message(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	
	
}
