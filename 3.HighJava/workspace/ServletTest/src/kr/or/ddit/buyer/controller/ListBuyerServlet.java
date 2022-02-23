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

@WebServlet(value="/buyer/list.do")
public class ListBuyerServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		IBuyerService service = BuyerServiceImpl.getInstance();
		System.out.println("여기까지 옴");
		
		List<BuyerVO> list = service.ListBuyer();
		
		String msg="";
		
		if(list==null) {
			msg="안녕";
		}
		System.out.println(msg);
		
		req.setAttribute("buyerList", list);
		
		req.getRequestDispatcher("/WEB-INF/views/buyer/list.jsp")
		                  .forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
