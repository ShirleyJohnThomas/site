package com.blossom.rq;

import java.io.IOException;

import com.blossom.rq.model.ParamsModel;
import com.blossom.rq.util.SystemExceptionEnum;
import com.blossom.tools.exception.SystemExceptionUtils;
import com.blossom.tools.object.ObjectUtils;
import com.blossom.tools.string.StringUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Description: 连接队列
 * @author Blossom
 * @time 2017年2月28日 上午10:08:25
 */
public abstract class EndPoint {
	
	protected ConnectionFactory factory;
	protected Channel channel;
	protected Connection connection;
	protected ParamsModel params;

	/**
	 * @author Blossom
	 * @throws IOException 
	 * @throws SystemExceptionUtils 
	 * @time 2017年2月28日 上午10:09:35
	 */
	public EndPoint(ParamsModel params) throws IOException, SystemExceptionUtils {
		if (ObjectUtils.isEmpty(params)) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}
		this.params = params;
		// 创建连接工厂
		factory = new ConnectionFactory();
		// 设置连接用户名
		if (!StringUtils.isEmpty(params.getUserName())) {
			factory.setUsername(params.getUserName());
		}
		// 设置连接密码
		if (!StringUtils.isEmpty(params.getPassword())) {
			factory.setPassword(params.getPassword());
		}
		// 设置虚拟主机
		if (!StringUtils.isEmpty(params.getVirtualHost())) {
			factory.setVirtualHost(params.getVirtualHost());
		}
		// 设置连接主机
		if (StringUtils.isEmpty(params.getHost())) {
			throw new SystemExceptionUtils(SystemExceptionEnum.SYSTEM_INCOMPLETE_PARAMETER_ERROR.toString());
		}else{
			factory.setHost(params.getHost());
		}
		//设置端口号
		if (!ObjectUtils.isEmpty(params.getPort())) {
			factory.setPort(params.getPort());
		}
		// 创建一个连接
		connection = factory.newConnection();
		// 创建一个通道
		channel = connection.createChannel();
		// 设置队列
		/*channel.queueDeclare("", false, false, false, null);*/
		
	}
	
	/**
	 * @Description: 关闭channel和connection;并非必须，会隐含调用
	 * @author Blossom
	 * @time 2017年2月28日 上午10:17:49 
	 * @return_type void
	 *
	 */
	public void close() throws IOException{
		this.channel.close();
		this.connection.close();
	}
	
}
