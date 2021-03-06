package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.NoticeVO;
import kr.or.ddit.board.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class NotiBoardDaoImpl implements INotiBoardDao{
	private static INotiBoardDao dao ;
	private SqlMapClient smc ;
	
	private NotiBoardDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	public static INotiBoardDao getInstance() {
		if(dao==null) {
			dao = new NotiBoardDaoImpl();
		}
		
		return dao;
	}
	@Override
	public int insertNotice(NoticeVO nv) throws SQLException {
		return (int) smc.insert("notice.insertNotice", nv);
	}
	@Override
	public int noticeSize() throws SQLException {
		return (int) smc.queryForObject("notice.noticeSize");
	}
	@Override
	public NoticeVO selectNotiBoard(int adminboard_id) throws SQLException {
	
		return (NoticeVO) smc.queryForObject("notice.selectNotiBoard", adminboard_id);
	}
	@Override
	public int noticeUpdate(NoticeVO nv) throws SQLException {
		return smc.update("notice.noticeUpdate", nv);
	}
	@Override
	public int NoticeDelete(int adminboard_id) throws SQLException {
		return smc.delete("notice.NoticeDelete", adminboard_id);
	}
	@Override
	public List<NoticeVO> findTitle(PagingVO pv) throws SQLException {
		return smc.queryForList("notice.findTitle", pv);
	}
	@Override
	public List<NoticeVO> findContent(PagingVO pv) throws SQLException {
		return smc.queryForList("notice.findContent", pv);
	}
	@Override
	public int findtitleCount(String notice_title) throws SQLException {
		return (int) smc.queryForObject("notice.findtitleCount", notice_title);
	}
	@Override
	public int findcontentCount(String notice_content) throws SQLException {
		
		return (int) smc.queryForObject("notice.findcontentCount", notice_content);
	}

}
