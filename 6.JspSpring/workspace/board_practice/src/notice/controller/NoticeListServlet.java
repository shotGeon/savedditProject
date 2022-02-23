package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import notice.dao.INoticeDao;
import notice.dao.NoticeDaoImpl;
import notice.dataSource.OracleMyBatisSqlSessionFactory;
import notice.dto.NoticeVO;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;


public class NoticeListServlet extends HttpServlet {
	private INoticeService noticeservice;
	{
		noticeservice = new NoticeServiceImpl();
		SqlSessionFactory sqlSessionFactory = new OracleMyBatisSqlSessionFactory();
		INoticeDao noticeDAO = new NoticeDaoImpl();
		((NoticeServiceImpl)noticeservice).setSqlSessionFactory(sqlSessionFactory);
		((NoticeServiceImpl)noticeservice).setNoticeDAO(noticeDAO);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/notice/list.jsp";
		List<NoticeVO> impList = null;
		List<NoticeVO> norList = null;
		
		try {
			impList = noticeservice.getImportantList();
		
			norList = noticeservice.getNormalList();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
//		request.setAttribute("impList", impList);
//		request.setAttribute("norList", norList);
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

	
}
