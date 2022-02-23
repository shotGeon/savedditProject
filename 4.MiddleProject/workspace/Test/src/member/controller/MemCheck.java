package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemCheck
 */
@WebServlet("/MemCheck.do")
public class MemCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int cnt = service.memCheck(id);
		
		request.setAttribute("check", cnt);
		
		request.getRequestDispatcher("/WEB-INF/whole/member_jsp/MemCheck.jsp").forward(request, response);
		
	}

}
