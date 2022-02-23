package member.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberFile extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("옴");
		String url="/member/regist.jsp";
		req.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String saveDir = context.getRealPath("Upload");
		
		System.out.println("saveDir:"+saveDir);
		int maxsize = 3*1024*1024;
		
		
		MultipartRequest multi = new MultipartRequest(req, saveDir, maxsize, "utf-8", new DefaultFileRenamePolicy());
		
//		String fileName = multi.getFilesystemName("file");
//		System.out.println("file:"+fileName);
		// TODO Auto-generated method stub
	}

}
