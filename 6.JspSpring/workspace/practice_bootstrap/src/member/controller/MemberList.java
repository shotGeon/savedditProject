package member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import command.Criteria;
import command.SearchCriteria;
import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.service.SearchMemberServiceImpl;
import member.vo.MemberVO;
import util.MyBatisSqlSessionFactory;


public class MemberList extends HttpServlet {
	private IMemberService memberService;
	
	{
		memberService = new SearchMemberServiceImpl();
		SqlSessionFactory factory = new MyBatisSqlSessionFactory();
		IMemberDao memberDAO = new MemberDaoImpl();
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
		((MemberServiceImpl)memberService).setSqlSessionFactory(factory);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/memberList.jsp";
		String pageStr = request.getParameter("page");
		String perPageNumStr = request.getParameter("perPageNum");
		String searchTypeParam = request.getParameter("searchType");
		String keywordParam = request.getParameter("keyword");
		try {
			Criteria cri = null;
			if(pageStr !=null && perPageNumStr !=null) {
				cri = new SearchCriteria(pageStr, perPageNumStr, searchTypeParam, keywordParam);
				
			}else {
				cri = new SearchCriteria();
			}
			Map<String, Object> dataMap = memberService.memberListPage(cri);
			
			List<MemberVO> memberList =(List<MemberVO>)dataMap.get("memberList");
			
			request.setAttribute("dataMap", dataMap);
			
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
