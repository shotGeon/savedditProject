package kr.or.ddit.adminClass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.adminClass.service.AdminClassServiceImpl;
import kr.or.ddit.adminClass.service.IAdminClassService;
import kr.or.ddit.adminClass.vo.AdminClassVO;
import kr.or.ddit.board.vo.PagingVO;

/**
 * Servlet implementation class SelectAllClass
 */
@WebServlet("/SelectAllClass.do")
public class SelectAllClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이징
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));

		IAdminClassService service = AdminClassServiceImpl.GetService();
		
		// 페이징
		int totalCnt = service.classSize();
		PagingVO pv = new PagingVO();
		pv.setCountPerPage(18);
		pv.setCurrentPageNo(pageNo);
		pv.setPageSize(3);
		pv.setTotalCount(totalCnt);
		
		List<AdminClassVO> list = service.groupByAllClass(pv);
		
		request.setAttribute("pv", pv);
		request.setAttribute("classList", list);
		
		request.getRequestDispatcher("/whole/admin/admin_jsp/SelectAllClass.jsp").forward(request, response);
	}

}
