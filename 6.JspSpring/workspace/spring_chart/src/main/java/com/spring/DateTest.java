package com.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	
	public static void main(String[] args) {
		String dateStr = "2021-01-20";
		
		String dateStr2 = dateStr.replaceAll("-", "");
		System.out.println("dateStr2"+dateStr2);
		
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date formatData = dtFormat.parse(dateStr2);
			String strnewfo = newDtFormat.format(formatData);
			System.out.println("formatData:"+formatData);
			System.out.println("3:"+strnewfo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}

}
