package com.jsp.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.jws.soap.InitParam;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;


public class AccessFilterServlet implements Filter {

	HashSet<Enum> set = new HashSet<>();
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String url = ((HttpServletRequest)request).getRequestURL().toString();
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		System.out.println(loginUser);
		
		if(url.endsWith("remove") || url.endsWith("modify") || url.endsWith("regist")) {
			if(loginUser.getEnabled() == 1) {
				chain.doFilter(request, response);
			}
			else {
				PrintWriter out = ((HttpServletResponse)response).getWriter();
				out.print("<script>");
				out.print("alert('해당 기능에 접근 할 권한이 없습니다.');");
				out.print("</script>");
			}
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}




}
