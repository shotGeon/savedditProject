package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestParsing2 {
	
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			String urlstr="http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo?year=2020&pageNo=1&numOfRows=100&returnType=xml&serviceKey="
					+ "jnO7kWmiB2N9pbk4eTUNlc4eUD3kfNR%2Br3cb34jsKnMY%2FTRb%2BQQygH9%2FT9Mm3xZkQ8jtnOxSlFoaZ7QIpfvC2A%3D%3D";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
			String result="";
			String line;
			while((line = br.readLine())!=null) {
				result = result+line+"\n";
			}
			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	

}
