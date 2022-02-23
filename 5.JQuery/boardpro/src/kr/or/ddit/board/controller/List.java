package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class List
 */
@WebServlet("/List.do")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전체리스트 가져오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		java.util.List<BoardVO> list = service.selectAll();
		
		request.setAttribute("allList", list);
		
		request.getRequestDispatcher("board/list.jsp").forward(request, response);
		
		
	}
	
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//페이지별 리스트 가져오기
    	//클라이언트 요청시 전송되는 데이터 가져오기
    	int spage = Integer.parseInt(request.getParameter("page"));
    	
    	IBoardService service = BoardServiceImpl.getInstance();
    	
    	int perList = 5;
    	
    	int perPage = 3;
    	
    	//전체 페이지 수 구하기(저장된 글 갯수 /perList)
    	int cnt = service.getListCount();
    	
    	int totalPage = (int) Math.ceil(cnt/(double)perList);
    	
    	int startPage = ((spage-1) /perPage *perPage)+1;
    	
    	int endPage = startPage + perPage -1 ;
    	
    	if(endPage > totalPage) endPage=totalPage;
    	
 
    	//spage 의 값에 따라서 start와 end값이 변경
    	int start = (spage-1)*perList +1;
    	int end = start +perList -1;
    	
    	if(end >cnt) end=cnt;
    	
    	
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	
    	map.put("start", start);
    	map.put("end", end);
    	
    	java.util.List<BoardVO> list = service.selectByPage(map);
    	
    	request.setAttribute("pageList", list);
    	//시작페이지
    	request.setAttribute("spage", startPage);
    	//마지막페이지
    	request.setAttribute("epage", endPage);
    	//총페이지
    	request.setAttribute("tpage", totalPage);
    	//현재페이지
    	request.setAttribute("curpage", spage);
    	
    	
    	request.getRequestDispatcher("board/listPage.jsp").forward(request, response);
    	 
		
		
		
		
	}
	

}
