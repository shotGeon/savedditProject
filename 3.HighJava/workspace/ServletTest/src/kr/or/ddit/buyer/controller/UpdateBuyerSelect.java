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

@WebServlet("/buyer/update.do")
public class UpdateBuyerSelect extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String buyer_id = req.getParameter("buyer_id");
		
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		req.setAttribute("buyer_id", buyer_id);
		
		req.getRequestDispatcher("/WEB-INF/views/buyer/update.jsp").
							forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String buyer_id= req.getParameter("buyer_id");
		System.out.println("buyer_id: "+buyer_id);
		String buyer_name =req.getParameter("buyer_name");
		System.out.println("buyer_name: "+buyer_name);
		String buyer_comtel =req.getParameter("buyer_comtel");
		String buyer_fax =req.getParameter("buyer_fax");
		
		BuyerVO bv = new BuyerVO();
		
		bv.setBuyer_id(buyer_id);
		bv.setBuyer_name(buyer_name);
		bv.setBuyer_comtel(buyer_comtel);
		bv.setBuyer_fax(buyer_fax);
		
		req.setAttribute("updateBuyer", bv);
		
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		int cnt = service.updateBuyer(bv);
		
		String msg = "";
		
		if(cnt>0) {
			msg="성공";
		}else {
			msg="실패";
		}
		
		String redirectUrl =req.getContextPath()
				+"/buyer/list.do?msg="+URLEncoder.encode(msg, "UTF-8");
		
		resp.sendRedirect(redirectUrl);
		
		
	}
}
