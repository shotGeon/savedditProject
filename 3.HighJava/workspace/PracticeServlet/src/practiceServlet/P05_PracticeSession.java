package practiceServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class P05_PracticeSession extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션가져오기 없으면 새로 자동 생성
		HttpSession session = req.getSession(true);
		
		//생성시간 가져오기
		Date createTime = new Date(session.getCreationTime());
		
		//마지막 접근시간 가져오기
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		
		String title="재방문을 환영합니다.";
		int visitCount =0;
		String userId="sem";
		
		if(session.isNew()) {
			title="처음 방문을 환영합니다.";
			session.setAttribute("userId", userId);
		}else {
			visitCount=(Integer) session.getAttribute("visitCount");
			visitCount++;
			
			userId=(String) session.getAttribute("userId");
		}
		System.out.println("visitCount :"+visitCount);
		session.setAttribute("visitCount", visitCount);
		
		session.setMaxInactiveInterval(30);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head><title>"+title+"</title></head>"
				+ "<body>"
				+ "<h1 align=\"center\">"+title+"</h1>"
				+ "<h2 align=\"center\">세션정보</h2>"
				+ "<table border=\"1\" align=\"center\">"
				+ "<tr bgcolor=\"orange\"><th>구분</th><th>값</th></tr>"
				+ "<tr><td>세션ID</td><td>"+session.getId()+"</td></tr>"
				+ "<tr><td>생성시간</td><td>"+createTime+"</td></tr>"
				+ "<tr><td>마지막 접근시간</td><td>"+lastAccessTime+"</td></tr>"
				+ "<tr><td>UserId</td><td>"+userId+"</td></tr>"
				+ "<tr><td>방문횟수</td><td>"+visitCount+"</td></tr>"
				+ "</table></body></html>");
	
	}
		
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
