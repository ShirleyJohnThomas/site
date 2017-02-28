package com.blossom.rq.test;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.SerializationUtils;

import com.blossom.rq.EndPoint;
import com.blossom.rq.model.ParamsModel;
import com.blossom.tools.exception.SystemExceptionUtils;

/**
 * @Description: 生产者
 * @author Blossom
 * @time 2017年2月28日 上午10:21:29
 */
public class Product extends EndPoint {

	/**
	 * @deprecated: 工作队列
	 * @author Blossom
	 * @time 2017年2月28日 上午11:26:01
	 * @param params 连接参数
	 * @param queue 队列名称
	 * @param durable 是否持久化
	 * @param exclusive 是否唯一
	 * @param autoDelete 是否自动删除
	 * @param arguments 参数
	 * @throws IOException
	 * @throws SystemExceptionUtils
	 */
	public Product(ParamsModel params,String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String,Object> arguments) throws IOException, SystemExceptionUtils {
		super(params);
		//设置队列
		channel.queueDeclare(queue, durable, exclusive, autoDelete, arguments);
	}
	
	/**
	 * @deprecated: 交换机(发布)
	 * @author Blossom
	 * @time 2017年2月28日 上午11:53:26
	 * @param params
	 * @param exchange
	 * @param type
	 * @param durable
	 * @param autoDelete
	 * @param arguments
	 * @throws IOException
	 * @throws SystemExceptionUtils
	 */
	public Product(ParamsModel params,String exchange, String type, boolean durable, boolean autoDelete,Map<String,Object> arguments) throws IOException, SystemExceptionUtils {
		super(params);
		//设置路由
		channel.exchangeDeclare(exchange, type,durable,autoDelete,arguments);
		
	}
	
	/**
	 * @Description: 消息发送
	 * @author Blossom
	 * @throws CloneNotSupportedException 
	 * @time 2017年2月28日 上午10:24:06 
	 * @return_type void
	 *
	 */
	public void sendMessage(Serializable object,String endPointName) throws IOException, CloneNotSupportedException{
		channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
		clone();
	}
	
	/**
	 * @Description: 消息发送
	 * @author Blossom
	 * @time 2017年2月28日 上午11:37:34 
	 * @return_type void
	 *
	 */
	public void sendMessage(Map<String, Serializable> map) throws IOException{
		
		for (Entry<String, Serializable> entry : map.entrySet()) {
			channel.basicPublish("", entry.getKey(), null, SerializationUtils.serialize(entry.getValue()));
		}
	}

}
