package kr.or.ddit.buyer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

/**
 * Servlet implementation class Bydetail
 */
@WebServlet("/Bydetail.do")
public class Bydetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bydetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		BuyerVO vo= service.selectDetail(request.getParameter("id"));
		
		request.setAttribute("SelDetail", vo);
		
		request.getRequestDispatcher("0930/buyerDetail.jsp").forward(request, response);
		
		
	
	}

}
