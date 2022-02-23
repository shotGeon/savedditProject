package util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import exception.NotMultipartFormDataException;
import sun.security.ssl.HandshakeMessage;

public class MultipartHttpServletRequestParser {

	Map<String, String[]> paramString = new HashMap<>();
	Map<String, List<FileItem>> paramFile = new HashMap<>();
	
	public MultipartHttpServletRequestParser(HttpServletRequest request,
											int memory_threshold,
											int max_file_size,
											int max_request_size)
											throws NotMultipartFormDataException,
												   UnsupportedEncodingException,
												   FileUploadException{
		ServletFileUpload upload = ServletFileUploadBuilder
						.build(request, memory_threshold, max_file_size, max_request_size);
		
		List<FileItem> formItems = upload.parseRequest(request);
		
		if(formItems !=null) {
			for(FileItem item : formItems) {
				String paramName = item.getFieldName();
				
				if(item.isFormField()) {
					String[] paramValues = item.getString("utf-8").split(",");
					this.paramString.put(paramName, paramValues);
				}else {
					List<FileItem> files = this.paramFile.get(paramName);
					
					if(files ==null) {
						files = new ArrayList<FileItem>();
						this.paramFile.put(paramName, files);
					}
					files.add(item);
				}
			}
		}
	}
	
	
	public String getParameter(String name) {
		String[] values = this.paramString.get(name);
		String result=null;
		if(values!=null) {
			result = values[0];
		}
		
		return result;
	}
	
	public String[] getParameterValues(String name) {
		String[] values = null; 
		values=this.paramString.get(name);
		
		return values;
	}
	
	public Enumeration<String> getParameterNames(){
		List<String> paramNames = new ArrayList<>();
		
		if(paramString.size()>0) {
			for(String paramName : paramString.keySet()) {
				paramNames.add(paramName);
			}
		}
		Enumeration<String> result = Collections.enumeration(paramNames);
		
		return result;
	}
	
	public FileItem getFileItem(String paramName) {
		List<FileItem> itemList = paramFile.get(paramName);
		
		FileItem result = null;
		
		if(itemList !=null) {
			result = itemList.get(0);
		}
		return result;
	}
	
	public FileItem[] getFileItems(String paramName) {
		List<FileItem> items = paramFile.get(paramName);
		
		FileItem[] files = null;
		
		if(items !=null) {
			files = new FileItem[items.size()];
			items.toArray(files);
		}
		
		return files;
	}
	
	
	
	
}
