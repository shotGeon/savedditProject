package com.jsp.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.utils.GetUploadPath;

public class MemberGetPictureAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url = null;

		String fileName = request.getParameter("picture");
		System.out.println("picture:"+fileName);

		String savedPath = GetUploadPath.getUploadPath("member.picture.upload");
		System.out.println("savePath:"+savedPath);
		
		FileDownloadResolver.sendFile(fileName, savedPath, request, response);
		return url;
	}

}
