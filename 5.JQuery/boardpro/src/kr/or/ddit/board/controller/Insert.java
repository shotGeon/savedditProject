package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//0. 클라이언트 요청시 데이터 전달받는다.
		
		BoardVO bv = new BoardVO();
		
		try {
			BeanUtils.populate(bv, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//서버에서 클라이언트 아이피를 갖고와서 저장
		bv.setWip(request.getRemoteAddr());
		
		//1.service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		//2.service 메소드 호출하기
		int cnt =service.insertBoard(bv);
		//3.결과값 req에 저장
		request.setAttribute("result", cnt);
		
		//4.jsp로 forward(result.jsp로)
		
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
		
		
		
	}

}
