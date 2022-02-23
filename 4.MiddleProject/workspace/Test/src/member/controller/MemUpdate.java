package member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.oreilly.servlet.MultipartRequest;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemVO;

/**
 * Servlet implementation class MemUpdate
 */
@WebServlet("/MemUpdate.do")
public class MemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		
		String saveDir = context.getRealPath("Upload");
		System.out.println("절대경로>>"+saveDir);
		int maxSize = 3*1024*1024;//3MB
		String encoding ="utf-8";
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding);
		
		String fileName = multi.getFilesystemName("file");
		System.out.println("fileName:"+fileName);
		
		String id = multi.getParameter("ID");
		String pwd = multi.getParameter("PWD");

		String email = multi.getParameter("EMAIL");

		int enabled  = Integer.parseInt(multi.getParameter("ENABLED"));
		String regdate = multi.getParameter("REGDATE");

		String phone    = multi.getParameter("PHONE");

		String name     = multi.getParameter("NAME");

		String register = multi.getParameter("REGISTER");

		String address  = multi.getParameter("ADDRESS");

		String authority= multi.getParameter("AUTHORITY");
		
		
		MemVO mv = new MemVO();	
		
		mv.setId(id);
		mv.setPwd(pwd);
		mv.setEmail(email);
		mv.setPicture(fileName);
		mv.setEnabled(enabled);
		mv.setPhone(phone);
		mv.setName(name);
		mv.setAddress(address);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int cnt = service.memUpdate(mv);
		
		request.setAttribute("id", mv.getId());
		
		request.setAttribute("update", cnt);
		
		request.getRequestDispatcher("/WEB-INF/whole/member_jsp/MemUpdate.jsp").forward(request, response);
		
	}

}
