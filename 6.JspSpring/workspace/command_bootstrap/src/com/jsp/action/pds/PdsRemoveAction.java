package com.jsp.action.pds;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.service.PdsService;

public class PdsRemoveAction implements Action{
	private PdsService pdsServie;
	
	public void setPdsService(PdsService pdsService) {
		this.pdsServie=pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url ="/pds/remove_success";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		try {
			List<AttachVO> attachList = pdsServie.getPds(pno).getAttachList();
			
			if(attachList !=null) {
				for(AttachVO attach : attachList) {
					String storedFilePath = attach.getUploadPath()+File.separator+attach.getFileName();
					
					File removeFile = new File(storedFilePath);
					
					if(removeFile.exists()) {
						removeFile.delete();
					}
					
				}
			}
			pdsServie.remove(pno);
		} catch (Exception e) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url=null;
			e.printStackTrace();
		}
		
		return url;
	}

}
