package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

public class MemberListServlet extends HttpServlet {
	private MemberDAO memberDAO = new MemberDAOImpl();
	MemberService service = new MemberServiceImpl();
	
	{
		((MemberServiceImpl)service).setMemberDAO(memberDAO);
	}
	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/memberList.jsp";
	
		List<MemberVO> memberList = new ArrayList<>();
		
		try {
			memberList=service.getMemberList();
			request.setAttribute("memberList", memberList);
		} catch (Exception e) {
			e.printStackTrace();
			url="/error/500.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
