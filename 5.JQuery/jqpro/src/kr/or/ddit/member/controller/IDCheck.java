package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class IDCheck
 */
@WebServlet("/IDCheck.do")
public class IDCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDCheck() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0.클라이언트 요청시 전송데이터를 받는다
		String userId = request.getParameter("id");
		
		//1.service객체 얻기
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		//2.service메소드 호출하기 - 결과값 받기
		
		String id=service.selectById(userId);
		
		//3.결과값을 request에 저장
		request.setAttribute("selectId", id);
		//4.jsp로 forward -1005/idcheck.jsp
		request.getRequestDispatcher("1005/idcheck.jsp").forward(request, response);
		
	}

}
