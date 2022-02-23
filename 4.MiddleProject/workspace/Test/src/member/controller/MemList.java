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
 * Servlet implementation class MemList
 */
@WebServlet("/MemList.do")
public class MemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MemList() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = request.getParameter("pageNo")==null?
				1 : Integer.parseInt(request.getParameter("pageNo"));
		
		String field=request.getParameter("f");
		String query=request.getParameter("q");
		
		System.out.println("field:"+field);
		System.out.println("query:"+query);

		PagingVO pagingVO = new PagingVO();

		IMemberService service = MemberServiceImpl.getInstance();
		
		if(field!=null) {
			pagingVO.setField(field);
			pagingVO.setQuery(query);
			
			int cnt = service.memFindTotalCount(pagingVO);
			System.out.println("cnt:"+cnt);
			pagingVO.setTotalCount(cnt);
			
		}
		
		if(field==null) {
			int totalCnt = service.memTotalCount();
			System.out.println("totalCnt:"+totalCnt);
			pagingVO.setTotalCount(totalCnt);
		}
		
		
		pagingVO.setCountPerPage(5);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setPageSize(15);
		
		List<MemVO> list = service.memPagingList(pagingVO);
		
		
		request.setAttribute("list", list);
		
		request.setAttribute("pagingVO", pagingVO);
		
		request.getRequestDispatcher("/WEB-INF/whole/member_jsp/MemList.jsp").forward(request, response);
		
		
	}

}
