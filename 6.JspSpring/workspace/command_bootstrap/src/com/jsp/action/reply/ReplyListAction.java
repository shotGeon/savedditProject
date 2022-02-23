package com.jsp.action.reply;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.CriteriaCommand;
import com.jsp.command.SearchCriteria;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.controller.JSONResolver;
import com.jsp.controller.ViewResolver;
import com.jsp.dto.ReplyVO;
import com.jsp.service.ReplyService;

public class ReplyListAction implements Action{
	private ReplyService replyService;
	
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url=null;
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno:"+bno);
		
		try {
			CriteriaCommand criCmd = (CriteriaCommand)HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);
			
			SearchCriteria cri = criCmd.toSearchCriteria();
			
			Map<String, Object> getReplyList= replyService.getReplyList(bno, cri);
			
			JSONResolver.view(response,getReplyList);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		return url;
	}

}
