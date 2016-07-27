package com.xiaojiyun.www.producer;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

import com.xiaojiyun.www.converter.NotifyMessageConverter;
import com.xiaojiyun.www.model.MsgModel;

/**
 * The Class QueueMessageProducer.
 */
public class QueueMessageProducer {
	 
 	/** The jms template. */
 	private JmsTemplate jmsTemplate;
	 
 	/** The notify queue. */
 	private Destination notifyQueue;
	 
 	/** The message converter. */
 	private NotifyMessageConverter messageConverter;
	 
	 /**
 	 * Send queue.
 	 *
 	 * @param msg the msg
 	 */
 	public void sendQueue(MsgModel msg){
	  sendMessage(msg);
	 }
	 
 	/**
 	 * Send message.
 	 *
 	 * @param msg the msg
 	 */
 	private void sendMessage(MsgModel msg) {
	  jmsTemplate.setMessageConverter(messageConverter);
	  jmsTemplate.setPubSubDomain(false);
	  jmsTemplate.convertAndSend(notifyQueue,msg);
	 }
	 
 	/**
 	 * Gets the jms template.
 	 *
 	 * @return the jms template
 	 */
 	public JmsTemplate getJmsTemplate() {
	  return jmsTemplate;
	 }
	 
 	/**
 	 * Sets the jms template.
 	 *
 	 * @param jmsTemplate the jms template
 	 */
 	public void setJmsTemplate(JmsTemplate jmsTemplate) {
	  this.jmsTemplate = jmsTemplate;
	 }
	 
 	/**
 	 * Gets the notify queue.
 	 *
 	 * @return the notify queue
 	 */
 	public Destination getNotifyQueue() {
	  return notifyQueue;
	 }
	 
 	/**
 	 * Sets the notify queue.
 	 *
 	 * @param notifyQueue the notify queue
 	 */
 	public void setNotifyQueue(Destination notifyQueue) {
	  this.notifyQueue = notifyQueue;
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
