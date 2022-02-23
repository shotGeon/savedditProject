package com.jsp.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jsp.dto.AttachVO;

public class MakeFileName {
	
	public static String toUUIDFileName(String fileName, String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}
	
	public static String parseFileNameFromUUID(String fileName, String delimiter) {
		String[] beforeFileName=fileName.split(delimiter);
		
		String afterFileName=beforeFileName[beforeFileName.length-1];
		
		return afterFileName;
	}
	public static List<AttachVO> parseFileNameFromAttaches(List<AttachVO> attachList, String delimiter){
		System.out.println("delemiter:"+delimiter);
		List<AttachVO> renamedAttachList = new ArrayList<AttachVO>();
		
		if(attachList !=null) {
			for(AttachVO attach : attachList) {
				String fileName = attach.getFileName();
				fileName = parseFileNameFromUUID(fileName, delimiter);
				attach.setFileName(fileName);
				
				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}
}
