package kr.or.ddit.cal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.cal.service.CalServiceImpl;
import kr.or.ddit.cal.service.ICalService;
import kr.or.ddit.cal.vo.TtVO;

/**
 * Servlet implementation class TtIdSelect
 */
@WebServlet("/TtIdSelect.do")
public class TtIdSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TtIdSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String tt_title = request.getParameter("tt_title");
		String tt_start = ((String)request.getParameter("tt_start")).replaceAll("-", "").replaceAll("T", "").replaceAll(":", "");
		String tt_end = ((String)request.getParameter("tt_end")).replaceAll("-", "").replaceAll("T", " ").replaceAll(":", "");
		String tt_color = (String)request.getParameter("tt_color");
		
		TtVO vo = new TtVO();
		
		vo.setTt_title(tt_title);
		vo.setTt_start(tt_start);
		vo.setTt_end(tt_end);
		vo.setTt_color(tt_color);
		
	
		
		ICalService service = CalServiceImpl.getInstance();
		
		int tt_id = service.ttIdSelect(vo);
		
		request.setAttribute("tt_id", tt_id);
		
		request.getRequestDispatcher("/WEB-INF/whole/cal_jsp/tt_id.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
