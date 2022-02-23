package com.spring.scheduler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogScheduler {
	private String savePath;
	private String fileName;
	
	public void setSavePath(String savePath) {
		this.savePath=savePath;
	}
	
	public void setFileName(String fileName) {
		this.fileName=fileName;
	}
	
	public void dataWrite() throws Exception{
		System.out.println("실행!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("savePath:"+savePath);
		System.out.println("fileName:"+fileName);
		String mcode="sfjskdjf";
		
		double temp =(double)(Math.random()*20+20);
		
		String tempStr= String.valueOf(temp);
		
		//System.out.println(tempStr);
		
		String log=fusion(mcode,tempStr);
		
		File file = new File(savePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String filePath = savePath+File.separator+fileName;
		System.out.println("filePath:"+filePath);
		BufferedWriter out = new BufferedWriter(new FileWriter(filePath,true));
		
		out.write(log);
		out.newLine();
		out.close();
		
	}
	
	
	public String fusion(String ...strings) {
		String[] fusion =strings;
		String tag="[center:template]";
		String baegito =tag
						+"기계코드:"+ fusion[0]+","
						+"온도:"+fusion[1]+","
						+"시간:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		return baegito; 
	}
}
