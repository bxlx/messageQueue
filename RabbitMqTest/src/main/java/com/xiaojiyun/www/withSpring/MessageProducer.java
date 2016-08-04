package com.xiaojiyun.www.withSpring;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
	

	@Resource
	private AmqpTemplate amqpTemplate;

	public void sendMessage(Object message){
	  amqpTemplate.convertAndSend("queueTestKey",message);
	}
}