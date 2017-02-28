package com.blossom.rq.consumer;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;

import com.blossom.rq.EndPoint;
import com.blossom.rq.model.MessageModel;
import com.blossom.rq.model.ParamsModel;
import com.blossom.tools.exception.SystemExceptionUtils;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * @Description: 消费者
 * @author Blossom
 * @time 2017年2月28日 上午10:24:52
 */
public class QueueConsumer extends EndPoint {
	
	private String queue;

	/**
	 * @author Blossom
	 * @time 2017年2月28日 上午10:25:05
	 * @param endPointName
	 * @throws IOException
	 * @throws SystemExceptionUtils
	 */
	public QueueConsumer(ParamsModel params, String queue, boolean durable, boolean exclusive, boolean autoDelete,
			Map<String, Object> arguments) throws IOException, SystemExceptionUtils {
		super(params);
		this.queue = queue;
		// 设置队列
		channel.queueDeclare(queue, durable, exclusive, autoDelete, arguments);
	}

	public void doWork() throws IOException{
		//每次从队列中获取一条数据
		channel.basicQos(1);
		Consumer consumer = new DefaultConsumer(channel){
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
				MessageModel message = (MessageModel)SerializationUtils.deserialize(body);
				//接收到的数据处理
				System.out.println(message.toString());
				
				channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};
		channel.basicConsume(queue, false,consumer);
		
	}

}
