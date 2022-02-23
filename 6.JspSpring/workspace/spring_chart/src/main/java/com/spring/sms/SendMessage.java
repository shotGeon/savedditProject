package com.spring.sms;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SendMessage {
	public static void main(String[] args) {
		new SendMessage().testSend();
	}
	public void testSend() { 
		String api_key = "NCSAPXSIFKAYD8MM"; //사이트에서 발급 받은 API KEY 
		String api_secret = "SPVLAXK5IDMRJEREVXRBTBWMXY8OVIER"; //사이트에서 발급 받은 API SECRET KEY 
		Message coolsms = new Message(api_key, api_secret); 
		HashMap<String, String> params = new HashMap<String, String>(); 
		params.put("to", "01084828986");
		params.put("from", "01064757568"); //사전에 사이트에서 번호를 인증하고 등록하여야 함 
		params.put("type", "SMS"); params.put("text", "내 이름은 이민영 난 가끔 눈물을 흘린다.....또잉또잉"); //메시지 내용
		params.put("app_version", "test app 1.2"); 
		try { 
			JSONObject obj = (JSONObject) coolsms.send(params); 
			System.out.println(obj.toString()); //전송 결과 출력 
		} catch (CoolsmsException e) {
				System.out.println(e.getMessage());
		
				System.out.println(e.getCode()); 
	   }
		
		
	}

}








