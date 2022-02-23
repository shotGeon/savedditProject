package member.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import exception.NotMultipartFormDataException;
import util.GetUploadPath;
import util.MultipartHttpServletRequestParser;
import util.SaveFileResolver;

/**
 * Servlet implementation class PictureUploadMemberServlet
 */
@WebServlet("/member/picture")
public class PictureUploadMemberServlet extends HttpServlet {
	
	private static final int MEMORY_THREADHOLD = 1024*500;
	private static final int MAX_FILE_SIZE = 1024*1024*1;
	private static final int MAX_REQUEST_SIZE= 1024*1024*2;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String uploadFileName =null;
		
		MultipartHttpServletRequestParser multi=null;
		//1.request 변환
		 try {
			multi = new MultipartHttpServletRequestParser
								(request, MEMORY_THREADHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
		} catch (NotMultipartFormDataException e) {
			response.sendError(response.SC_BAD_REQUEST);
			return;
		} catch (FileUploadException e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			
		}
		//2.저장할 경로
		String uploadPath = GetUploadPath.getUploadPath("member.picture.upload");
		
		//3.업로드된 이미지 저장
		FileItem[] items = multi.getFileItems("pictureFile");
		
		try {
			List<File> uploadFiles = SaveFileResolver.fileUpload(items, uploadPath);
			uploadFileName = uploadFiles.get(0).getName();
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		//4.이전 이미지 삭제
		String oldPicture = multi.getParameter("oldPicture");
		File oldFile = new File(uploadPath +File.separator+oldPicture);
		if(oldFile.exists()) {
			oldFile.delete();
		}
		//5.저장한 파일명 보내기
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(uploadFileName);
		
	}

}
