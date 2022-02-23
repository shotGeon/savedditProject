package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Paging.PagingVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemVO;

/**
 * Servlet implementation class MemChkDelete
 */
@WebServlet("/MemChkDelete.do")
public class MemChkDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemChkDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chk = request.getParameter("chk");
		System.out.println("chk:"+chk);
		
		int pageNo = request.getParameter("pageNo") == null?
				1 : Integer.parseInt(request.getParameter("pageNo"));
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		String[] idarr = chk.split(",");
		for(int i=0; i<idarr.length; i++) {
			service.memDelete(idarr[i]);
		}
		
		int totalCnt = service.memTotalCount();
		
		PagingVO pagingVO = new PagingVO();
		
		pagingVO.setCountPerPage(5);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setPageSize(15);
		pagingVO.setTotalCount(totalCnt);
		
		List<MemVO> list = service.memPagingList(pagingVO);
		
		request.setAttribute("list", list);
		request.setAttribute("pagingVO", pagingVO);
		
		request.getRequestDispatcher("/WEB-INF/whole/member_jsp/MemList.jsp")
													.forward(request, response);
		
		
		
		
		
	}

}
