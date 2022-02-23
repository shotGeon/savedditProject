package member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import Paging.PagingVO;
import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import memberVO.MemVO;
import util.MyBatisSqlSessionFactory;


public class MemberList extends HttpServlet {
	private IMemberService memberservice;
	
	{
		memberservice = new MemberServiceImpl();
		SqlSessionFactory factory = new MyBatisSqlSessionFactory();
		IMemberDao memberDAO = new MemberDaoImpl();
		((MemberServiceImpl)memberservice).setMemberDao(memberDAO);
		((MemberServiceImpl)memberservice).setSqlSessionFactory(factory);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/home.jsp";
		
		try {
			List<MemVO> memberList = memberservice.memberList();
			for(int i=0; i<memberList.size(); i++) {
				if(memberList.get(i).getEnabled()==0) {
					memberList.get(i).setEnabledName("퇴사");
				}
				if(memberList.get(i).getEnabled()==1) {
					memberList.get(i).setEnabledName("재직");
				}
				if(memberList.get(i).getEnabled()==2) {
					memberList.get(i).setEnabledName("휴직");
				}
			}
			
			request.setAttribute("memberList", memberList);
			
		} catch (Exception e1) {
			e1.printStackTrace();
			url="/error/errorPage.jsp";
			
		}
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
