package kr.or.ddit.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.admin.service.AdminServiceImpl;
import kr.or.ddit.admin.service.IAdminService;

/**
 * Servlet implementation class DleleteMember
 */
@WebServlet("/DeleteMember.do")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = request.getParameter("memId");
		
		IAdminService service = AdminServiceImpl.GetService();
		int cnt = 0;
		String chk = request.getParameter("chk");
		String[] num = chk.split(",");
		for(int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
			String mem_id = num[i];
			cnt = service.deleteMember(mem_id);
		}
		
		
		request.setAttribute("result", cnt);
		
		request.getRequestDispatcher("/whole/admin/admin_jsp/result.jsp").forward(request, response);
	}

}
