package kr.or.ddit.clat.controller;

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
import kr.or.ddit.clboard.vo.ClBoardVO;
import kr.or.ddit.clboard.service.BoardServiceImpl;
import kr.or.ddit.clboard.service.IBoardService;
import kr.or.ddit.member.vo.MemVO;
import kr.or.ddit.util.FileUploadRequestWrapper;

/**
 * Servlet implementation class InsertAtBoard
 */
@WebServlet("/InsertClAtHomeworkBoard.do")
public class InsertClAtHomeworkBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertClAtHomeworkBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemVO mv = (MemVO) session.getAttribute("mem");
		
		ClBoardVO bv = new ClBoardVO();
		
		int num = 0;
		if(((FileUploadRequestWrapper)request).isMultipartContent()) {
			
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			Map<String, String[]> parameterMap = ((FileUploadRequestWrapper)request).getParameterMap();
			
			String title = parameterMap.get("board_title")[0].replaceAll("<", "&lt;").replaceAll("\"", "&quot;").replaceAll("'", "&#39;").replaceAll("\\\\", "&#92;");
			String content = parameterMap.get("board_content")[0].replaceAll("<", "&lt;").replaceAll("\"", "&quot;").replaceAll("'", "&#39;").replaceAll("\\\\", "&#92;").replaceAll("\n", "<br>");
			
			
			bv.setClboard_title(title);
			bv.setClboard_content(content);
			bv.setMem_id(mv.getMem_id());
			bv.setBoard_title_id(parameterMap.get("board_title_id")[0]);
			bv.setClass_id(mv.getClass_id());
			
			IBoardService service = BoardServiceImpl.getInstance();
			num = service.InsertBoard(bv);
			
			AtVO fileVO = new AtVO();
			Map<String, FileItem[]> fileItemMap = ((FileUploadRequestWrapper)request).getFileItemMap();
			
			
			fileVO.setAdminboard_id(num);
			fileVO.setFile_cn(mv.getMem_name());
			if(fileItemMap.size() > 0) {
				try {
					fileVO = fileService.saveAtchFileList(fileItemMap, fileVO);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		request.setAttribute("adminboard_id", num);
		
		request.getRequestDispatcher("/WEB-INF/whole/at_jsp/InsertBoard.jsp").forward(request, response);
	}

}
