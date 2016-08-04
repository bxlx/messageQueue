package com.xiaojiyun.www.withSpring;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationcontext.xml", "classpath:rabbitmq.xml"})
public class withSpringTest {

	@Resource
	private MessageProducer messageProducer;
	
	@Test
	public void test() {
		messageProducer.sendMessage("xiaojiyun");
	}

}
