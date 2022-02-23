package com.jsp.action.common;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import com.jsp.action.Action;
import com.jsp.controller.MultipartHttpServletRequestParser;
import com.jsp.controller.SaveFileResolver;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.utils.GetUploadPath;

public class SummernoteUploadImgAction implements Action{
	private static final int MEMORY_THRESHOLD = 1024 * 500; // 500KB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 5; // 5MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 10; // 10MB
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url=null;
		
		//1.request parsing
		try {
		
		MultipartHttpServletRequestParser multi = 
				new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
		//2.upload path
		String uploadPath = GetUploadPath.getUploadPath("summernote.img");
		
		//3.file save : get file list
		FileItem[] items = multi.getFileItems("file");
		
		List<File> uploadFiles = SaveFileResolver.fileUpload(items, uploadPath);
		
		//System.out.println("listSize:"+uploadFiles.size());
		//reponse out
		response.setCharacterEncoding("utf-8");
		
		
		PrintWriter out = response.getWriter();
		
		
		if(uploadFiles.size()>0) {
			for(File file : uploadFiles) {
				out.print(request.getContextPath()+"/getImg.do?fileName="
						+file.getName());
			}
		}
		
		}catch(NotMultipartFormDataException e) {
			e.printStackTrace();
			response.sendError(response.SC_BAD_REQUEST);
		}catch(Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		return url;
	}

}
