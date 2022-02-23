package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

/**
 * Servlet implementation class ByName
 */
@WebServlet("/ByName.do")
public class ByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ByName() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 요청 전송시 데이터를 받는다 - 현재는 없다.
		
		//1. service객체 얻어오기
		IBuyerService service = BuyerServiceImpl.getInstance();
		//2. service메소드 호출하기
		List<BuyerVO> list= service.selectByName();
		
		//3.결과값을 request에 저장
		request.setAttribute("SelByName", list);
		//4.jsp로 forward - 출력 , json데이터 생성
		request.getRequestDispatcher("0930/buyerNames.jsp").forward(request, response);
		
	}

}
