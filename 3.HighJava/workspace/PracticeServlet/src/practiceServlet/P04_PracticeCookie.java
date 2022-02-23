package practiceServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class P04_PracticeCookie extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿠키설정
		//setCookieExam(req, resp);
		
		//쿠키읽기
		//readCookieExam(req,resp);
		
		//쿠키삭제
		deleteCookieExam(req,resp);
	}
	
	
	private void deleteCookieExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Cookie[] cookies = req.getCookies();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		String title="쿠키정보 삭제 예제";
		
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head><title>"+title+"</title></head>"
				+ "<body>");
		if(cookies != null) {
			out.println("<h2>"+title+"</h2>");
			
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("userId")) {
					//쿠키 제거하기
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					out.println("삭제한 쿠키:"
							+cookie.getName()+"<br>");
				}
				out.print("쿠키이름: "+cookie.getName()+",");
				out.print("쿠키값: "
						+URLDecoder.decode(cookie.getValue(), "UTF-8")+"<br>");
			}
		}else {
			out.println("<h2>쿠키 정보가 없습니다. </h2>");
		}
		out.println("</body>");
		out.println("</html>");
	}


	private void readCookieExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Cookie[] cookies = req.getCookies();
		
		//응답헤더 인코딩 및 content-type 설정
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		String title ="쿠키정보 읽기 예제";
		
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head><title>"+title+"</title></head>"
				+ "<body>");
		if(cookies != null) {
			out.println("<h2>"+title+"</h2>");
			
			for(Cookie cookie : cookies) {
				out.println("name:"+cookie.getName()+"<br>");
				out.println("value:"
						+URLDecoder.decode(cookie.getValue(), "UTF-8")
						+"<br>");
				out.println("<hr>");
			}
		}else {
			out.println("<h2>쿠키 정보가 없습니다. </h2>");
		}
		out.println("</body>");
		out.println("</html>");
		
	}


	private void setCookieExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Cookie userId = new Cookie("userId", req.getParameter("userId"));
		
		Cookie name = new Cookie(
				"name", URLEncoder.encode(req.getParameter("name"),"UTF-8"));
		//쿠키소멸시간 설정
		userId.setMaxAge(60*60*24);//1일
		//javaScript를 이용한 직접 접근방지(XSS공격방지)
		userId.setHttpOnly(true);
		name.setMaxAge(60*60*48);//2일
		
		resp.addCookie(userId);
		resp.addCookie(name);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		String title="쿠키 설정 예제";
		
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<title>"+title+"</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1 align=\"center\">"+title+"</h1>"
				+ "<ul>"
				+ "<li><b>ID</b>:"
				+ req.getParameter("userId")+"</li>"
				+ "<li><b>이름</b>:"
				+ req.getParameter("name")+"</li>"
				+ "</ul>"
				+ "</body>"
				+ "</html>");
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
