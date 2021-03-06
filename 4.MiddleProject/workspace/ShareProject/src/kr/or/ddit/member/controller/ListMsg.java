package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.vo.PagingVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MsgVO;

/**
 * Servlet implementation class ListMsg
 */
@WebServlet("/ListMsg.do")
public class ListMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMsg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String msg_from = (String) session.getAttribute("mem_id");
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
		String group = request.getParameter("group");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int totalCnt = service.msgSize(msg_from);
		
		PagingVO pv = new PagingVO();
		pv.setCountPerPage(20);
		pv.setCurrentPageNo(pageNo);
		pv.setPageSize(10);
		pv.setTotalCount(totalCnt);
		pv.setMsg_from(msg_from);
		
		List<MsgVO> list = service.groupByAllMsg(pv);
		
		request.setAttribute("pv", pv);
		request.setAttribute("msgList", list);
		
		request.getRequestDispatcher("/WEB-INF/whole/member_jsp/ListMessage.jsp")
														.forward(request, response);
	
		
	}

}
