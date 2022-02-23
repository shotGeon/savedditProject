package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;

public class DispatcherServlet extends HttpServlet {

	private HandlerMapper handlerMapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String handlerProperty = config.getInitParameter("handlerProperty");
		System.out.println("handlerProperty:"+handlerProperty);
		try {
			if(handlerProperty != null && !handlerProperty.isEmpty()) {
				handlerMapper = new HandlerMapper(handlerProperty);
			}else {
				handlerMapper = new HandlerMapper();
			}
			System.out.println("[DispatcherServlet] handlerMapper 가 준비되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("[DispatcherServlet] handlerMapper 가 준비되지 않았습니다.");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String command = request.getRequestURI(); //contextpath 포함
		//System.out.println("command:"+command);
		if(command.indexOf(request.getContextPath())==0) { //contextpath 삭제
			command = command.substring(request.getContextPath().length());
		}
		System.out.println("command:"+command);
		//commandHandler 실행(handlerMapper 의뢰 handler 할당)
		Action action = null;
		String view = null;
		if(handlerMapper != null) {
			action = handlerMapper.getAction(command);
			if(action != null) {
				System.out.println(1);
				view = action.execute(request, response);
				if(view!=null) {
					request.setAttribute("viewName", view);
					ViewResolver.view(request, response);
				}
				
			}else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		}else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
