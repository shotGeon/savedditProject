package com.jsp.action.common;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MenuVO;
import com.jsp.service.MenuService;

public class IndexAction implements Action {
	
	private MenuService menuService;
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url="/common/indexPage"; // /WEB-INF/mainviews/common/indexPage.jsp
		
		String mCode = request.getParameter("mCode");
		if(mCode==null) mCode="M000000";
		try {
			List<MenuVO> menuList = menuService.getMainMenuList();
			MenuVO menu = menuService.getMenuByMcode(mCode);
			
			request.setAttribute("menu", menu);
			
			request.setAttribute("menuList", menuList);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url=null;
		}
		
		return url;
	}

}
