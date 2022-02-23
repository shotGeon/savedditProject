package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	
	public  static void view(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String url = (String)request.getAttribute("viewName");
		System.out.println("옴2 url:"+url);
		if(url ==null) {
			return;
		}
		
		if(url.indexOf("redirect:") >-1) {
			String contextPath = request.getContextPath();
			
			url = contextPath +url.replace("redirect:", "");
			System.out.println("옴3:"+url);
			response.sendRedirect(url);
			
		}else {
			String prefix = "/WEB-INF/mainviews";
			String subfix = ".jsp";
			url = prefix +url +subfix;
			System.out.println("옴3:"+url);
			
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
	
}
