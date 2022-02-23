package com.java.utils;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;

public class Message {
	
	private static Message instance;

	private Properties property = new Properties();
	
	private Message() {
	}
	
	public static Message getInstance() {
		if (instance==null) {
			instance = new Message();
		}
		
		return instance;
	}
	
	
	public void init(String propertiesUrl) throws IOException{
		
		Reader reader = Resources.getResourceAsReader(propertiesUrl);
		
		property.load(reader);
		
	}
	
	public String getMsg(String key) {
		
		String message = property.getProperty(key);
		
		return message;
		
	}
	
	
	
}
