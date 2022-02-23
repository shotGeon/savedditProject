package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;

@WebServlet("/buyer/delete.do")
public class DeleteBuyerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String buyer_id=req.getParameter("buyer_id");
		
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		System.out.println("딜리트  buyer_id"+buyer_id);
		int cnt=service.deleteBuyer(buyer_id);
		
		String msg="";
		if(cnt>0) {
			msg="성공";
		}else {
			msg="실패";
		}
		
		String redirectUrl = req.getContextPath()
				+"/buyer/list.do?msg="+URLEncoder.encode(msg, "UTF-8");
		
		resp.sendRedirect(redirectUrl);
		
	}
}
