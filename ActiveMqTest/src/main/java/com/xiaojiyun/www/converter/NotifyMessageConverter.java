package com.xiaojiyun.www.converter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.xiaojiyun.www.model.MsgModel;

public class NotifyMessageConverter implements MessageConverter{
	
	/**
  	 * 转换接收到的消息为NoticeInfo对象
	 */
	public Object fromMessage(Message message) throws JMSException,MessageConversionException {
		if (message instanceof ObjectMessage) {
			ObjectMessage oMsg = (ObjectMessage)message;
				if (oMsg instanceof ActiveMQObjectMessage) {
					ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage)oMsg;
					try {
						MsgModel msg = (MsgModel)aMsg.getObject();
						return msg;
					} catch (Exception e) {
						// TODO: handle exception
						throw new JMSException("Message:"+message.toString()+"is not a instance of NoticeInfo."+message.toString());
					}
				}else{

					throw new JMSException("Message:"+message.toString()+"is not a instance of ActiveMQObjectMessage."+message.toString());
				}
		}else {
			throw new JMSException("Message:"+message.toString()+"is not a instance of ObjectMessage."+message.toString());
		}
	}

	 
	 /**
	  * 转换NoticeInfo对象到消息
	  */
	public Message toMessage(Object obj, Session session) throws JMSException,MessageConversionException {
		if (obj instanceof MsgModel) {
			ActiveMQObjectMessage msg = (ActiveMQObjectMessage)session.createObjectMessage();
			msg.setObject((MsgModel)obj);
			return msg;
		}
		return null;
	}
	
}
