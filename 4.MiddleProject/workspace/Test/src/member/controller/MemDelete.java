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
 * Servlet implementation class MemDelete
 */
@WebServlet("/MemDelete.do")
public class MemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		
		System.out.println("delete:"+id);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int cnt = service.memDelete(id);
		System.out.println(cnt);
		
		request.setAttribute("delete", cnt);
		
		request.getRequestDispatcher("/WEB-INF/whole/member_jsp/MemDelete.jsp").forward(request, response);
		
		
	}

}
