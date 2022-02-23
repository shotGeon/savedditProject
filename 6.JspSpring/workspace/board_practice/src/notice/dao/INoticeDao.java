package notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.dto.NoticeVO;

public interface INoticeDao {
	
	public List<NoticeVO> selectImportantNoticeList(SqlSession session) throws Exception;
	
	public List<NoticeVO> selectNormalNoticeList(SqlSession session) throws Exception;

}
