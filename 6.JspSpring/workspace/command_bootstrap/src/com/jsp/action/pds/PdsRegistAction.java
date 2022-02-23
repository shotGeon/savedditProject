package com.jsp.action.pds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.SaveFileResolver;
import com.jsp.controller.XSSMultipartHtttpServletRequestParser;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.PdsService;
import com.jsp.utils.GetUploadPath;


public class PdsRegistAction implements Action{
	private PdsService pdsService;
	
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}
	
	final private int MEMORY_THRESHOLD=1024*1024*3;
	final private int MAX_FILE_SIZE=1024*1024*40;
	final private int MAX_REQUEST_SIZE=1024*1024*200;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url="/pds/regist_success";
		
		XSSMultipartHtttpServletRequestParser multi=null;
		
		List<AttachVO> attachList = null;
		
		String uploadPath = GetUploadPath.getUploadPath("pds.upload");
		try {
			
		multi = new XSSMultipartHtttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
		
		List<File> fileList = SaveFileResolver.fileUpload(multi.getFileItems("uploadFile"), uploadPath);
		
		if(fileList !=null) {
			attachList = new ArrayList<AttachVO>();
			for(File file : fileList) {
				AttachVO attach = new AttachVO();
				attach.setFileName(file.getName());
				attach.setUploadPath(uploadPath);
				attach.setFileType(file.getName().substring(file.getName().lastIndexOf(".")+1));
				attachList.add(attach);
			}
			
		}
		PdsVO pds = new PdsVO();
		pds.setTitle(multi.getXSSParameter("title"));
		pds.setContent(multi.getParameter("content"));
		pds.setWriter(multi.getParameter("writer"));
		pds.setAttachList(attachList);
		
		pdsService.regist(pds);
		}catch(NotMultipartFormDataException e) {
			response.sendError(response.SC_BAD_REQUEST);
			url=null;
			e.printStackTrace();
		}catch(IOException e) {
			url=null;
			e.printStackTrace();
		}catch(Exception e) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url = null;
			e.printStackTrace();
		}
		return url;
	}

}
