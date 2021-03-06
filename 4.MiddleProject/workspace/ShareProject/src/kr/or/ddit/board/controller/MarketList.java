package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.at.service.AtchFileServiceImpl;
import kr.or.ddit.at.service.IAtchFileService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PagingVO;

/**
 * Servlet implementation class ListBoard
 */
@WebServlet("/MarketList.do")
public class MarketList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MarketList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청 페이지 번호
		int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
		String board_title_id = request.getParameter("group");
		HttpSession session = request.getSession();
		
		String mem_id = (String) session.getAttribute("mem_id");
		
		System.out.println("mem_id:"+mem_id);
	
		// 1.서비스 객체 생성하기
		IBoardService service = BoardServiceImpl.getInstance();

		// 1.2 페이징 객체 생성
		int totalCnt = service.selectTotalCnt(board_title_id);
		String endDate = service.getClassEndDate(mem_id);
		
		PagingVO pv = new PagingVO();
		pv.setCountPerPage(8);
		pv.setCurrentPageNo(pageNo);
		pv.setPageSize(8);
		pv.setTotalCount(totalCnt);
		pv.setGroup(board_title_id);
		// 2. group에 해당하는 boardList
		List<BoardVO> boardList = service.groupByAllBoard(pv); 
		String board_title_name = service.getBoardTitle(board_title_id);
		
		Map<Integer, Integer> atchIdMap = new HashMap<Integer, Integer>();
		for(BoardVO vo : boardList) {
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			int atchFileId = fileService.selectAtchId(vo.getAdminboard_id());
			
			if(atchFileId > 0) {
				
				atchIdMap.put(vo.getAdminboard_id(), atchFileId);
			}
		}
		System.out.println(atchIdMap);
		
		request.setAttribute("atchIdMap", atchIdMap);
		request.setAttribute("mem_id", mem_id);
		request.setAttribute("class_end", endDate);
		request.setAttribute("pv", pv);
		request.setAttribute("boardList", boardList);
		request.setAttribute("board_title_id", board_title_id);
		request.setAttribute("board_title_name", board_title_name);

		request.getRequestDispatcher("/WEB-INF/whole/board_jsp/MarketList.jsp").forward(request, response);
	}
}
