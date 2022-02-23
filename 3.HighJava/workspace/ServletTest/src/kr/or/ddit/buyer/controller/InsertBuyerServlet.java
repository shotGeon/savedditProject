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
import kr.or.ddit.buyer.vo.BuyerVO;

@WebServlet(value="/buyer/insert.do")
public class InsertBuyerServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/buyer/insertForm.jsp").forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String buyer_id = req.getParameter("buyer_id");
		String buyer_name = req.getParameter("buyer_name");
		String buyer_lgu = req.getParameter("buyer_lgu");
		String buyer_comtel = req.getParameter("buyer_comtel");
		String buyer_fax= req.getParameter("buyer_fax");
		String buyer_mail = req.getParameter("buyer_mail");
		String buyer_bank = req.getParameter("buyer_bank");
		String buyer_add1 = req.getParameter("buyer_add1");
		String buyer_add2 = req.getParameter("buyer_add2");
		
		BuyerVO bv = new BuyerVO();
		
		bv.setBuyer_id(buyer_id);
		bv.setBuyer_name(buyer_name);
		bv.setBuyer_lgu(buyer_lgu);
		bv.setBuyer_comtel(buyer_comtel);
		bv.setBuyer_fax(buyer_fax);
		bv.setBuyer_mail(buyer_mail);
		bv.setBuyer_bank(buyer_bank);
		bv.setBuyer_add1(buyer_add1);
		bv.setBuyer_add2(buyer_add2);
		
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		int cnt=service.insertBuyer(bv);
		
		String msg="";
		
		if(cnt>0) {
			msg="성공!!";
		}else {
			msg="실패!!";
		}
		
		req.setAttribute("msg", msg);
		
		String redirectUrl = req.getContextPath()
				+"/buyer/list.do?msg="+URLEncoder.encode(msg, "UTF-8");
		resp.sendRedirect(redirectUrl);
		
		
	
	}
	
}
