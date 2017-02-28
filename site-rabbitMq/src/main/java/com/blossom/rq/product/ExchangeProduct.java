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
 * @Description:交换机
 * @author Blossom
 * @time 2017年2月28日 下午1:44:50
 */
public class ExchangeProduct extends EndPoint implements ISendMessage {

	/**
	 * @deprecated: 交换机
	 * @author Blossom
	 * @time 2017年2月28日 下午1:46:22
	 * @param params 连接参数
	 * @param exchange 交换机名称
	 * @param type  交换机类型
	 * 				direct （直连）
	 *				topic （主题）
	 *				headers （标题）
	 *				fanout （分发）也有翻译为扇出的
	 * @param durable 是否持久化
	 * @param autoDelete 是否自动删除
	 * @param arguments 参数
	 * @throws IOException
	 * @throws SystemExceptionUtils
	 */
	public ExchangeProduct(ParamsModel params,String exchange,String type, boolean durable, boolean autoDelete, Map<String,Object> arguments) throws IOException, SystemExceptionUtils {
		super(params);
		//设置路由
		channel.exchangeDeclare(exchange, type,durable,autoDelete,arguments);
	}

	/**
	 * @Description: 发送多条消息
	 * @author Blossom
	 * @time 2017年2月28日 下午2:16:51
	 * @see com.blossom.rq.product.inter.ISendMessage#sendMessage(java.util.List)
	 */
	public void sendMessage(List<MessageModel> pList) {
		int length = pList.size();
		for(int i=0 ;i<length;i++){
			sendMessage(pList.get(i));
		}
	}

	/**
	 * @Description: 发送一条消息
	 * @author Blossom
	 * @time 2017年2月28日 下午2:16:51
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
