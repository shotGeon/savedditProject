package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.utils.Message;
import com.java.view.View;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Message message;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		message = Message.getInstance();
		
		try {
			message.init(config.getInitParameter("message.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인 화면 전송
		View.loginForm(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		boolean result = true;
		
		result = id.equals("mimi")&&pwd.equals("mimi");
		
		if(result) {
			View.alert(response, message.getMsg("message.loginSucces"));
			
		}else {
			View.alert(response,  message.getMsg("message.loginFail"));
			View.loginForm(request, response);
			
		}
		
	}

}
