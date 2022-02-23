package member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.service.SearchMemberServiceImpl;
import member.vo.MemberVO;


public class MemberInsert extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/memberInsert.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/check.jsp";
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		
		String saveDir = context.getRealPath("Upload");
		
		int maxsize = 3*1024*1024; 
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxsize,"utf-8",  new DefaultFileRenamePolicy());
		
		String id = multi.getParameter("id");
		
		String pwd = multi.getParameter("password");
		
		String email = multi.getParameter("email");
		
		String picture = multi.getFilesystemName("file");
		
		int enabled = Integer.parseInt(multi.getParameter("enabled"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String regdateStr =  multi.getParameter("regdate");
		Date regdate = new Date();
		if(regdateStr !=null) {
			try {
				regdate = sdf.parse(regdateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		String phone = multi.getParameter("phone");
		String name = multi.getParameter("name");
		String register = multi.getParameter("register");
		
		String address1 = multi.getParameter("address1");
		String address2 = multi.getParameter("address2");
		
		String address = address1+","+address2;
		
		String authority = multi.getParameter("authority");
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		memberVO.setEmail(email);
		memberVO.setPicture(picture);
		memberVO.setEnabled(enabled);
		memberVO.setRegdate(regdate);
		memberVO.setPhone(phone);
		memberVO.setName(name);
		memberVO.setRegister(register);
		memberVO.setAddress(address);
		memberVO.setAuthority(authority);
		
		IMemberService service = new SearchMemberServiceImpl();
		
		try {
			int count = service.memberInsert(memberVO);
			request.setAttribute("count", count);
		} catch (Exception e) {
			url="/error/insertErrorPage.jsp";
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
