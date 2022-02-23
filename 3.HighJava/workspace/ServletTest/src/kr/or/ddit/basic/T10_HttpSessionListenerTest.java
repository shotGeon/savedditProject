package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class T10_HttpSessionListenerTest extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//HttpSession 객체 생성 및 소멸관련 테스트
		HttpSession session = req.getSession();
		
		session.setAttribute("ATTR1", "속성1");
		session.setAttribute("ATTR1", "속성11");
		session.setAttribute("ATTR2", "속성2");
		
		session.removeAttribute("ATTR1");
		
		// HTTP 세션 영역 내에 HttpSessionBindingListener를 구현한 객체가
		// 바인딩 되면 호출됨.
		MySessionBindingListener bindingListener 
							= new MySessionBindingListener();
		session.setAttribute("obj", bindingListener);
		session.removeAttribute("obj");
		
		/////////////////////////////////////////////
		session.invalidate();//세션객체 삭제
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
}
