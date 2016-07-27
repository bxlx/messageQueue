package com.xiaojiyun.www.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaojiyun.www.model.MsgModel;
import com.xiaojiyun.www.producer.QueueMessageProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationcontext.xml"})
public class SendMsgTest {

	@Resource
	private QueueMessageProducer queueMessageProducer;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void test() {
		MsgModel msg = new MsgModel();
		msg.setContent("welcome to bxlx !");
		queueMessageProducer.sendQueue(msg);
	}

}
