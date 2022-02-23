package util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import exception.NotMultipartFormDataException;

public class ServletFileUploadBuilder {
	
	public static ServletFileUpload build(int MEMORY_THRESHOLD, int MAX_FILE_SIZE,
										  int MAX_REQUEST_SIZE) {
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		return upload;
		
	}
	
	public static ServletFileUpload build(HttpServletRequest request, int MEMORY_THRESHOLD, int MAX_FILE_SIZE,
			  int MAX_REQUEST_SIZE) throws NotMultipartFormDataException{
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			throw new NotMultipartFormDataException();
		}
		return build( MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
		
	}
	
	
	
}
