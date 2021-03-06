package kr.or.ddit.cal.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.cal.service.CalServiceImpl;
import kr.or.ddit.cal.service.ICalService;
import kr.or.ddit.cal.vo.TtVO;

/**
 * Servlet implementation class TtInsert
 */
@WebServlet("/TtInsert.do")
public class TtInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TtInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		TtVO vo = new TtVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vo.setTt_start(vo.getTt_start().replaceAll("-", "").replaceAll("T", "").replaceAll(":", ""));
		vo.setTt_end(vo.getTt_end().replaceAll("-", "").replaceAll("T", " ").replaceAll(":", ""));
		
		
		ICalService service = CalServiceImpl.getInstance();
		
		int cnt = service.ttInsert(vo);
		
		request.setAttribute("result", cnt);
		
		request.getRequestDispatcher("/WEB-INF/whole/cal_jsp/result.jsp").forward(request, response);
		
		
	}

}
