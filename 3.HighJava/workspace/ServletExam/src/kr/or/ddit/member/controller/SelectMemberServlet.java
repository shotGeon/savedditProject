package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.cmm.service.AtchFIleServiceImpl;
import kr.or.ddit.cmm.service.IAtchFileService;
import kr.or.ddit.cmm.vo.AtchFileVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/member/detail.do")
public class SelectMemberServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		
		//1. 서비스 객체 생성하기
		IMemberService memService = MemberServiceImpl.getInstance();
		
		//2. 회원정보 조회
		MemberVO mv = memService.getMember(memId);
		
		
		if(mv.getAtchFileId()> 0) {
			//첨부파일 정보 조회
			AtchFileVO fileVO = new AtchFileVO();
			fileVO.setAtchFileId(mv.getAtchFileId());
			
			IAtchFileService fileService = 
					  AtchFIleServiceImpl.getInstance();
			List<AtchFileVO> atchFileList = 
					fileService.getAtchFileList(fileVO);
			req.setAttribute("atchFileList", atchFileList);
			
		}
		
		
		//3. request객체에 회원정보 저장
		req.setAttribute("mv", mv);
		
		//4. View 화면으로 이동
		req.getRequestDispatcher("/WEB-INF/views/member/detail.jsp")
        .forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
}
