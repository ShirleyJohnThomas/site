package com.blossom.rq.model;

import java.io.Serializable;

import com.rabbitmq.client.AMQP.BasicProperties;



/**
 * @Description: 消息模型
 * @author Blossom
 * @time 2017年2月28日 下午1:58:24
 */
public class MessageModel implements Serializable{

	private static final long serialVersionUID = 7398278445081606845L;
	private String exchangeName;
	private String routingKey;
	private String type;
	private Serializable content;
	private Boolean mandatory;
	private BasicProperties props;
	
	
	/**
	 * @return the mandatory
	 */
	public Boolean getMandatory() {
		return mandatory;
	}
	/**
	 * @param mandatory the mandatory to set
	 */
	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}
	/**
	 * @return the props
	 */
	public BasicProperties getProps() {
		return props;
	}
	/**
	 * @param props the props to set
	 */
	public void setProps(BasicProperties props) {
		this.props = props;
	}
	/**
	 * @return the exchangeName
	 */
	public String getExchangeName() {
		return exchangeName;
	}
	/**
	 * @param exchangeName the exchangeName to set
	 */
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
	/**
	 * @return the queueName
	 */
	public String getRoutingKey() {
		return routingKey;
	}
	/**
	 * @param queueName the queueName to set
	 */
	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the content
	 */
	public Serializable getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(Serializable content) {
		this.content = content;
	}
	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年2月28日 下午2:34:55
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageModel [exchangeName=" + exchangeName + ", routingKey=" + routingKey + ", type=" + type
				+ ", content=" + content + ", mandatory=" + mandatory + ", props=" + props + "]";
	}
	
	
	
	
}
