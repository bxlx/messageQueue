package com.xiaojiyun.www.simple;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.SerializationUtils;

public class Producer extends EndPoint {
	
	public Producer(String endPointName) throws IOException, TimeoutException{
        super(endPointName);
    }
 
    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
    }  
}
