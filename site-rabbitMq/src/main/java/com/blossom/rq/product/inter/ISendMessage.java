package com.blossom.rq.product.inter;

import java.util.List;

import com.blossom.rq.model.MessageModel;

/**
 * @Description: 消息发送接口
 * @author Blossom
 * @time 2017年2月28日 下午1:55:14
 */
public interface ISendMessage {
	
	/**
	 * @Description: 发送多条消息
	 * @author Blossom
	 * @time 2017年2月28日 下午2:01:17 
	 * @return_type void
	 *
	 */
	void sendMessage(List<MessageModel> pList);
	
	/**
	 * @Description: 发送单条消息
	 * @author Blossom
	 * @time 2017年2月28日 下午2:01:57 
	 * @return_type void
	 *
	 */
	void sendMessage(MessageModel message);

}
