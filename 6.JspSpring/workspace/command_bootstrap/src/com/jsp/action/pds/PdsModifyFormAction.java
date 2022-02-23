package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;
import com.jsp.utils.MakeFileName;

public class PdsModifyFormAction implements Action{
	private PdsService pdsService;
	
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url = "/pds/modify";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		PdsVO pds = null;
		
		try {
			pds = pdsService.getPds(pno);
			List<AttachVO> renamedAttachList = MakeFileName.parseFileNameFromAttaches(pds.getAttachList(), "\\$\\$");
			
			pds.setAttachList(renamedAttachList);
			request.setAttribute("pds", pds);
		} catch (SQLException e) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url = null;
			e.printStackTrace();
		}
		return url;
	}

}
