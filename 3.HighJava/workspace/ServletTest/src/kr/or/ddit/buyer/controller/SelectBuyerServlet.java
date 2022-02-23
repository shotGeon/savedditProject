package kr.or.ddit.buyer.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

@WebServlet("/buyer/detail.do")
public class SelectBuyerServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String buyer_id = req.getParameter("buyer_id");
		
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		BuyerVO bv=service.selectBuyer(buyer_id);
		
		System.out.println("contextPath다:  "+req.getContextPath());
		
		req.setAttribute("selbuyer", bv);
		
		req.getRequestDispatcher("/WEB-INF/views/buyer/detail.jsp")
		.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
