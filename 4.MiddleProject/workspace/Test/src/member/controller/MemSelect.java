package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemVO;

/**
 * Servlet implementation class MemSelect
 */
@WebServlet("/MemSelect.do")
public class MemSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("ID");
		System.out.println(ID);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemVO mv = service.memSelect(ID);
		System.out.println("picture:"+mv.getPicture());
		
		System.out.println("enabled:"+mv.getEnabled());
		String name="";
		if(mv.getEnabled()==1){
			name="재직";
		}
		if(mv.getEnabled()==0){
			name="퇴사";
		}
		if(mv.getEnabled()==2){
			name="휴직";
		}
		
		request.setAttribute("mv", mv);
		request.setAttribute("name", name);
		
		request.getRequestDispatcher("/WEB-INF/whole/member_jsp/MemSelect.jsp").forward(request, response);
		
		
		
		
	}

}
