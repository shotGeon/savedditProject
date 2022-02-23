package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.service.SearchMemberServiceImpl;
import member.vo.MemberVO;
import util.MyBatisSqlSessionFactory;

/**
 * Servlet implementation class MemberIdCheckServlet
 */
@WebServlet("/member/idCheck")
public class MemberIdCheckServlet extends HttpServlet {
	private IMemberService memberService;
	
	{
		memberService = new SearchMemberServiceImpl();
		SqlSessionFactory factory = new MyBatisSqlSessionFactory();
		IMemberDao memberDAO = new MemberDaoImpl();
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
		((MemberServiceImpl)memberService).setSqlSessionFactory(factory);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String result="";
		PrintWriter out = response.getWriter();
		MemberVO member = null;
		
		try {
			member = memberService.getMember(id);
			if(member!=null) {
				result="DUPLICATED";
			}
			out.print(result);
			
		} catch (Exception e) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}finally {
			out.close();
		}
		
	}

	

}
