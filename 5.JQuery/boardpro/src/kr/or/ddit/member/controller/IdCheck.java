package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemVO;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count =0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemVO mv = new MemVO();
		
		try {
			BeanUtils.populate(mv, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemVO mv2 = service.idCheck(mv);
		
		if(mv2 ==null) {
			count++;
			if(count>5) {
				count=0;
			}
		}

		
		request.setAttribute("check", mv2);
		request.setAttribute("count", count);
		request.getRequestDispatcher("member/logcheck.jsp")
		 								.forward(request, response);
		
		
		
		
	}

}
