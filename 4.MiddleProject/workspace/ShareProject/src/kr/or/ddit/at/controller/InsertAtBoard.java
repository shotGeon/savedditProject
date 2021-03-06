package kr.or.ddit.at.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.at.service.AtchFileServiceImpl;
import kr.or.ddit.at.service.IAtchFileService;
import kr.or.ddit.at.vo.AtVO;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.FileUploadRequestWrapper;

/**
 * Servlet implementation class InsertAtBoard
 */
@WebServlet("/InsertAtBoard.do")
public class InsertAtBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAtBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");

		BoardVO bv = new BoardVO();

		int num = 0;
		if(((FileUploadRequestWrapper)request).isMultipartContent()) {
			
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			Map<String, String[]> parameterMap = ((FileUploadRequestWrapper)request).getParameterMap();
			
			String title = parameterMap.get("board_title")[0].replaceAll("<", "&lt;").replaceAll("\"", "&quot;").replaceAll("'", "&#39;").replaceAll("\\\\", "&#92;");
			String content = parameterMap.get("board_content")[0].replaceAll("<", "&lt;").replaceAll("\"", "&quot;").replaceAll("'", "&#39;").replaceAll("\\\\", "&#92;").replaceAll("\n", "<br>");
			
			bv.setBoard_title_id(parameterMap.get("board_title_id")[0]);
			bv.setBoard_title(title);
			bv.setBoard_content(content);
			bv.setMem_id(mem_id);
			
			IBoardService service = BoardServiceImpl.getInstance();
			num = service.InsertBoard(bv);
			
			AtVO fileVO = new AtVO();
			
			Map<String, FileItem[]> fileItemMap = ((FileUploadRequestWrapper)request).getFileItemMap();
			
			
			fileVO.setAdminboard_id(num);
			
			if(fileItemMap.size() > 0) {
				try {
					fileVO = fileService.saveAtchFileList(fileItemMap);
					
					System.out.println(fileVO);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		request.setAttribute("adminboard_id", num);
		
		request.getRequestDispatcher("/WEB-INF/whole/at_jsp/InsertBoard.jsp").forward(request, response);
	}

}
