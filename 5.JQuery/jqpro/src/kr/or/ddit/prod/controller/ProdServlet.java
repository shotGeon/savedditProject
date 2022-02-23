package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdServlet
 */
@WebServlet("/ProdServlet.do")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lprod_gu를 파라미터로 해서 prod_id와 prod_name을 가져오기
		
		//0.클라이언트 요청시 전송 데이터를 받는다. -lprod_gu(ajax에서 가져온다.)
		String lgu=request.getParameter("lprod_gu");
		//1.service객체 얻기
		IProdService service = ProdServiceImpl.getInstance();
		//2.service메소드 호출하기
		List<ProdVO> list= service.selectProdByLgu(lgu);
		
		//3.결과값을 requst에 저장하기
		request.setAttribute("selbylgu", list);
		
		//4.jsp로 포워드
		request.getRequestDispatcher("1001/prodNames.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//prod_id를 파라미터로 해서 상세보기를 한다.
		
		
		//0.클라이언트 요청시 전송 데이터를 받는다. -prod_id
		String pid = request.getParameter("prod_id");
		//1.service객체 얻기
		IProdService service = ProdServiceImpl.getInstance();
		
		//2.service메소드 호출하기
		ProdVO pv = service.selectByIddetail(pid);
		
		//3.결과값을 requst에 저장하기
		request.setAttribute("selbydetail", pv);
		
		//4.jsp로 포워드 -prodDetail.jsp
		request.getRequestDispatcher("1001/prodDetail.jsp").forward(request, response);
		
	}

}
