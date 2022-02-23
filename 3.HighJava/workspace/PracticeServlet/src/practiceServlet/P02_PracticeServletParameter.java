package practiceServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class P02_PracticeServletParameter extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gend = req.getParameter("gender");
		String hobby = req.getParameter("hobby");
		String rlgn = req.getParameter("rlgn");
		String[] foods = req.getParameterValues("food");
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		 out.println("<body>");
		out.println("<p>username :"+username+"</p>");
		out.println("<p>password :"+password+"</p>");
		out.println("<p>gend :"+gend+"</p>");
		out.println("<p>hobby :"+hobby+"</p>");
		out.println("<p>rlgn :"+rlgn+"</p>");
		
		if(foods !=null) {
			for(String food : foods) {
				out.println("<p>food :"+food+"</p>");
			}
		}
		out.println("</body>");
		out.println("</html>");
		
		throw new ServletException("practice 예외 발생");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		doGet(req, resp);
	}
}
