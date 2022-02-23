package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class SearchDong
 */
@WebServlet("/SearchDong.do")
public class SearchDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDong() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//POST에서는 인코딩을 먼저해야지 한글이 깨지지 않는다.
		request.setCharacterEncoding("UTF-8");
		
		//0.클라이언트 요청시 전송데이터 가져오기
		String dong=request.getParameter("dong");
		
		//1.service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		//2.service메소드 호출하기 - 결과값 가져오기
		List<ZipVO> list = service.selectZipCode(dong);
		
		//3.결과값을 request에 저장하기
		
		request.setAttribute("zipcode", list);
		
		//4.jsp forward -1005/zipcode.jsp
		request.getRequestDispatcher("1005/zipcode.jsp")
		                         .forward(request, response);
		
	}

}
