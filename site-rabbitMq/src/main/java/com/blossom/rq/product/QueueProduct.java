package com.blossom.rq.product;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;

import com.blossom.rq.EndPoint;
import com.blossom.rq.model.MessageModel;
import com.blossom.rq.model.ParamsModel;
import com.blossom.rq.product.inter.ISendMessage;
import com.blossom.tools.exception.SystemExceptionUtils;

/**
 * @Description:
 * @author Blossom
 * @time 2017年2月28日 下午1:41:01
 */
public class QueueProduct extends EndPoint implements ISendMessage{

	/**
	 * @deprecated: 队列
	 * @author Blossom
	 * @time 2017年2月28日 下午1:43:23
	 * @param params 连接参数
	 * @param queue	队列名称
	 * @param durable	是否持久化
	 * @param exclusive	是否唯一
	 * @param autoDelete 是否自动删除
	 * @param arguments 参数
	 * @throws IOException
	 * @throws SystemExceptionUtils
	 */
	public QueueProduct(ParamsModel params,String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String,Object> arguments) throws IOException, SystemExceptionUtils {
		super(params);
		//设置队列
		channel.queueDeclare(queue, durable, exclusive, autoDelete, arguments);
	}

	/**
	 * @Description: 发送多条信息
	 * @author Blossom
	 * @time 2017年2月28日 下午2:02:32
	 * @see com.blossom.rq.product.inter.ISendMessage#sendMessage(java.util.List)
	 */
	public void sendMessage(List<MessageModel> pList) {
		int length = pList.size();
		for(int i=0 ;i<length;i++){
			sendMessage(pList.get(i));
		}
	}

	/**
	 * @Description: 只发送一条信息
	 * @author Blossom
	 * @time 2017年2月28日 下午2:02:32
	 * @see com.blossom.rq.product.inter.ISendMessage#sendMessage(com.blossom.rq.model.MessageModel)
	 */
	public void sendMessage(MessageModel message) {
		try {
			channel.basicPublish(message.getExchangeName(), message.getRoutingKey(), message.getProps(), SerializationUtils.serialize(message.getContent()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
