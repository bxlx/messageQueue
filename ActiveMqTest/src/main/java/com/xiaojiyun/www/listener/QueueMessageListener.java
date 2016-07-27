package com.xiaojiyun.www.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.xiaojiyun.www.converter.NotifyMessageConverter;
import com.xiaojiyun.www.model.MsgModel;

/**
 * The Class QueueMessageListener.
 */
public class QueueMessageListener implements MessageListener{
	 
 	/** The message converter. */
 	private NotifyMessageConverter messageConverter;
	 
	 /**
 	 * 接收消息.
 	 *
 	 * @param message the message
 	 */
	 public void onMessage(Message message) {
		 try {
			 ObjectMessage objectMessage = (ObjectMessage)message;
			 MsgModel msg = (MsgModel)messageConverter.fromMessage(objectMessage);
			 System.out.println("queue收到消息 : "+msg.getContent());
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 /**
 	 * Gets the message converter.
 	 *
 	 * @return the message converter
 	 */
 	public NotifyMessageConverter getMessageConverter() {
		 return messageConverter;
	 }
	 
	 /**
 	 * Sets the message converter.
 	 *
 	 * @param messageConverter the message converter
 	 */
 	public void setMessageConverter(NotifyMessageConverter messageConverter) {
		 this.messageConverter = messageConverter;
	 }
}
