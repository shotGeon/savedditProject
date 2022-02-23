package com.jsp.action.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.NoticeService;

public class NoticeRemoveAction implements Action{
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeServie) {
		this.noticeService = noticeServie;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url="/notice/remove_success";
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		try {
			noticeService.remove(nno);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url=null;
		}
		
		return url;
	}

}
