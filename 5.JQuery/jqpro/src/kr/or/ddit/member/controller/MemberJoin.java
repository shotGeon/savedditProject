package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class MemberJoin
 */
@WebServlet("/MemberJoin.do")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoin() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//0. 클라이언트 요청시 전송 데이터
		
		
		MemberVO mv = new MemberVO();
		
		try {
			BeanUtils.populate(mv, request.getParameterMap());

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		/*mv.setMem_id(request.getParameter("mem_id"));
		mv.setMem_pass(request.getParameter("mem_pass"));
		mv.setMem_name(request.getParameter("mem_name"));
		mv.setMem_bir(request.getParameter("mem_bir"));
		mv.setMem_zip(request.getParameter("mem_zip"));
		mv.setMem_add1(request.getParameter("mem_add1"));
		mv.setMem_add2(request.getParameter("mem_add2"));
		mv.setMem_hp(request.getParameter("mem_hp"));
		mv.setMem_mail(request.getParameter("mem_mail"));
		*/
		
		//1. service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		//2. service메소드 호출해서 결과값 받기-입력한 id
		
		String insertId = service.insertMember(mv);
		
		//3. 결과값을 request에 저장하기
		
		request.setAttribute("insertId", insertId);
		
		//4.jsp로 포워드 
		request.getRequestDispatcher("1005/insert.jsp").forward(request, response);
		
	}

}
