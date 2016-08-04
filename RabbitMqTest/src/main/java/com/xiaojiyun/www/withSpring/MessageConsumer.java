package com.xiaojiyun.www.withSpring;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MessageConsumer implements MessageListener {

	public void onMessage(Message message) {
		System.out.println("receive message:"+new String(message.getBody()));
	}

}
