package kr.or.ddit.cal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.cal.service.CalServiceImpl;
import kr.or.ddit.cal.service.ICalService;
import kr.or.ddit.cal.vo.CalVO;

/**
 * Servlet implementation class CalList
 */
@WebServlet("/CalList.do")
public class CalList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String day = request.getParameter("day");
		
		
		ICalService service = CalServiceImpl.getInstance();
		
		List<CalVO> list = service.calenList();
		List<CalVO> list1 = service.calenListDetail(day);
		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
		
		request.getRequestDispatcher("/WEB-INF/whole/cal_jsp/calList.jsp").forward(request, response);
	}

}
