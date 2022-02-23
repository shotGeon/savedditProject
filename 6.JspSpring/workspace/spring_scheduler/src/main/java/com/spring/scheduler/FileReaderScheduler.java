package com.spring.scheduler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderScheduler {
	
	private String savePath;
	private String fileName;
	
	public void setSavePath(String savePath) {
		this.savePath=savePath;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void readFile() throws Exception{
		
		String filePath = savePath+File.separator+fileName;
		//System.out.println("readFile:"+filePath);
		File file = new File(filePath);
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line ="";
		List<String> storeList = new ArrayList<String>();
		
		while((line=in.readLine())!=null) {
			int num2=line.indexOf("]");
			String trans = line.substring(num2+1, line.length());
			String[] store = trans.split(",");
			storeList=Arrays.asList(store);
		}
		
		for(String text : storeList) {
			System.out.println("text:"+text);
		}
	}
	
	
	
	
}
