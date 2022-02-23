package notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import notice.dao.INoticeDao;
import notice.dto.NoticeVO;

public class NoticeServiceImpl implements INoticeService{
	protected SqlSessionFactory sqlSessionFactory;
	protected INoticeDao noticeDAO;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public void setNoticeDAO(INoticeDao noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	@Override
	public List<NoticeVO> getImportantList() throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		List<NoticeVO> impList = null;
		
		try {
			impList = noticeDAO.selectImportantNoticeList(session);
			session.commit();
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		
		return impList;
	}

	@Override
	public List<NoticeVO> getNormalList() throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		List<NoticeVO> norList = null;
		
		try {
			norList = noticeDAO.selectNormalNoticeList(session);
			
			session.commit();
			
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		return norList;
	}

}
