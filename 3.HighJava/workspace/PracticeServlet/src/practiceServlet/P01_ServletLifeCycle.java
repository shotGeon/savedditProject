package practiceServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class P01_ServletLifeCycle extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("p01 init()호출됨");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("p01 service 호출됨");
		super.service(arg0, arg1);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("p01 doGet()호출됨");
		
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		System.out.println("name =>"+name);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		PrintWriter out = resp.getWriter();
		
		out.println("name =>"+name);
		out.println("서블릿 경로:"+req.getServletPath());
		out.println("컨텍스트 경로:"+req.getContextPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("p01 doPost()호출됨");
		doGet(req, resp);
		
	}
	
	private void distroy() {
		System.out.println("destroy() 호출됨....");
	}

}
