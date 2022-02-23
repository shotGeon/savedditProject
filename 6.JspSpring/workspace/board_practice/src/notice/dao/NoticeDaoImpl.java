package notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.dto.NoticeVO;

public class NoticeDaoImpl implements INoticeDao{

	@Override
	public List<NoticeVO> selectImportantNoticeList(SqlSession session) throws Exception {
		List<NoticeVO> impList = null;
		
		impList = session.selectList("notice.selectImportantNoticeList");
		
		return impList;
	}

	@Override
	public List<NoticeVO> selectNormalNoticeList(SqlSession session) throws Exception {
		List<NoticeVO> norList = null;
		
		norList = session.selectList("notice.selectNormalNoticeList");
		
		return norList;
	}

}
