package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ClassVO;
import kr.or.ddit.member.vo.MemVO;

/**
 * Servlet implementation class Mypage
 */
@WebServlet("/Mypage.do")
public class Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mypage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mem_id = (String) session.getAttribute("mem_id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemVO mv = new MemVO();
		
		mv = service.memAll(mem_id);
		
		String class_id = mv.getClass_id();
		System.out.println("반 아이디: "+class_id);
		
		ClassVO cv = service.memClass(class_id);
		
		
		
		request.setAttribute("member", mv);
		
		request.setAttribute("class", cv);
		
		
		request.getRequestDispatcher("/WEB-INF/whole/member_jsp/mypage.jsp").forward(request, response);
		
	}

}
