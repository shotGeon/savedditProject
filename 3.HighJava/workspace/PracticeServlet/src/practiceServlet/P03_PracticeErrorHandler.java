package practiceServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class P03_PracticeErrorHandler extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//예외객체 
		Throwable throwable = (Throwable)req.getAttribute(
				 "javax.servlet.error.exception");
		//에러상태코드
		Integer statusCode=(Integer)req.getAttribute(
				"javax.servlet.error.status_code");
		//에러메시지
		String message = (String)req.getAttribute(
				"javax.servlet.error.message");
		//에러발생 서블릿 이름
		String servletName=(String)req.getAttribute(
				"javax.servlet.error.servlet_name");
		if(servletName == null) {
			servletName="알수없는 서블릿이름";
		}
		//에러발생 url정보
		String reqUri = (String)req.getAttribute(
				"javax.servlet.error.request_uri");
		if(reqUri==null) {
			reqUri="알수없는 uri";
		}
		
		//응답메시지 설정
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		String title = "Error/Exception 정보";
		
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head><title>"+title+"</title><head>"
				+ "<body>");
		if(throwable == null && statusCode ==null) {
			out.println("<h2>에러정보 없음</h2>");
		}else {
			out.println("<h2>예외/에러 정보</h2>");
			out.println("상태코드:"+statusCode+"<br><br>");
			out.println("에러메시지:"+message+"<br><br>");
			out.println("서블릿이름:"+servletName+"<br><br>");
			out.println("요청uri:"+reqUri+"<br><br>");
			
			if(statusCode !=null) {
				out.println("예외 타입:"
						+throwable.getClass().getName()+"<br><br>");
				out.println("예외 메시지:"+throwable.getMessage());
			}
		}
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
