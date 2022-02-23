package com.java.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dto.MemberVO;

/**
 * Servlet implementation class InObject
 */
@WebServlet("/InObject")
public class InObject extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		ServletContext application = request.getServletContext();
		
		request.setAttribute("msg", "캔디야 행복해라");
		request.setAttribute("msg", "캔디야 건강해라");
		session.setAttribute("msg", "캔디야 즐거워라");
		application.setAttribute("msg", "캔디야 배불러라");
		
		Map<String, String> dataMap = new HashMap<String,String>();
		dataMap.put("girlGroup", "에스파");
		
		request.setAttribute("dataMap", dataMap);
		
		MemberVO member = new MemberVO();
		
		member.setId("mimi");
		member.setPwd("mimi");
		
		request.setAttribute("member", member);
		
		request.getRequestDispatcher("/inObject.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
