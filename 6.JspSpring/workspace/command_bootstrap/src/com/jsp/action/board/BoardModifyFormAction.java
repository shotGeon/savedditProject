package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;

public class BoardModifyFormAction implements Action{
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url="/board/modify";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardVO board = null;
		
		try {
			board = boardService.getBoardForModify(bno);
			request.setAttribute("board", board);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url=null;
		}
		
		return url;
	}

}
