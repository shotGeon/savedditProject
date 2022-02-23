package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.session.SqlSessionFactory;

import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.service.SearchMemberServiceImpl;
import member.vo.MemberVO;
import util.MyBatisSqlSessionFactory;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {
	
	private IMemberService memberService;
	
	{
		memberService = new SearchMemberServiceImpl();
		SqlSessionFactory factory = new MyBatisSqlSessionFactory();
		IMemberDao memberDAO = new MemberDaoImpl();
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
		((MemberServiceImpl)memberService).setSqlSessionFactory(factory);
	}
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="/member/regist.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("옴");
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String pwd = request.getParameter("password");
		
		String email = request.getParameter("email");
		
		String picture = request.getParameter("picture");
		
		int enabled = Integer.parseInt(request.getParameter("enabled"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String regdateStr =  request.getParameter("regdate");
		
		Date regdate = new Date();
		if(regdateStr !=null) {
			try {
				regdate = sdf.parse(regdateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String register = request.getParameter("register");
		
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		String address = address1+","+address2;
		
		String authority = request.getParameter("authority");
		
		
		MemberVO member = new MemberVO();
		
		member.setId(id);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setPicture(picture);
		member.setEnabled(enabled);
		member.setRegdate(regdate);
		member.setPhone(phone);
		member.setName(name);
		member.setRegister(register);
		member.setAddress(address);
		member.setAuthority(authority);
		
		PrintWriter out = response.getWriter();
		
		try {
			int cnt = memberService.memberInsert(member);
			if(cnt>0) {
				out.print("INSERT");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		
		
		
	}

}
