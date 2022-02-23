package com.java.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View {
	
	private static void header(PrintWriter out, String title){
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println(title);
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		
		
	}
	
	private static void footer(PrintWriter out) {
		out.println("</body>");
		out.println("</html>");

	}
	
	public static void loginForm(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		header(out, "Login Page");
		
		
		out.println("<form action='login' method='post'>");
		out.println("아이디: <input type='text' name='id' value='"+(id !=null? id:"")+"' /><br/>");
		out.println("비밀번호: <input type='password' name='pwd'/><br/>");
		out.println("<input type='submit' value='로그인'/>");
		out.println("</form>");
		
		footer(out);
		
	}
	
	public static void alert(HttpServletResponse response, String message) throws ServletException, IOException{
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		
		out.println("alert('"+message+"')");
		
		out.println("</script>");
		
	}

}
