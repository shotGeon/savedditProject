package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.NoticeVO;
import kr.or.ddit.board.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {
	private static IBoardDao dao;
	private SqlMapClient smc;

	private BoardDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static IBoardDao getInstance() {
		if (dao == null)
			dao = new BoardDaoImpl();
		return dao;
	}

	@Override
	public int selectTotalCnt(String group) throws SQLException {
		return (int) smc.queryForObject("board.selectTotalCnt", group);
	}

	@Override
	public List<BoardVO> groupByAllBoard(PagingVO pv) throws SQLException {
		return smc.queryForList("board.groupByAllBoard", pv);
	}

	@Override
	public String getBoardTitle(String group) throws SQLException {
		return (String) smc.queryForObject("board.getBoardTitle", group);
	}

	@Override
	public BoardVO selectBoard(int adminboard_id) throws SQLException {
		return (BoardVO) smc.queryForObject("board.selectBoard", adminboard_id);
	}

	@Override
	public int InsertBoard(BoardVO bv) throws SQLException {
		return (int) smc.insert("board.insertBoard", bv);
	}

	@Override
	public int updateBoard(BoardVO bv) throws SQLException {
		return smc.update("board.updateBoard", bv);
	}

	@Override
	public int deleteBoard(int adminboard_id) throws SQLException {
		return smc.delete("board.deleteBoard", adminboard_id);
	}

	@Override
	public String getClassEndDate(String mem_id) throws SQLException {
		return (String) smc.queryForObject("board.getClassEndDate", mem_id);
	}

	@Override
	public List<NoticeVO> allNotiBoard(PagingVO pv) throws SQLException {
		return smc.queryForList("notice.allNotiBoard", pv);
	}
	
	//제목검색
	@Override
	public List<BoardVO> findBoTitle(PagingVO pv) throws SQLException {
		
		return smc.queryForList("board.findBoTitle", pv);
	}
	
	//내용검색
	@Override
	public List<BoardVO> findBoContent(PagingVO pv) throws SQLException {
		return smc.queryForList("board.findBoContent", pv);
	}

	@Override
	public int findBotitleCount(String board_title) throws SQLException {
		
		return (int) smc.queryForObject("board.findBotitleCount", board_title);
	}

	@Override
	public int findBocontentCount(String board_content) throws SQLException {
		
		return (int) smc.queryForObject("board.findBocontentCount", board_content);
	}

	@Override
	public int countView(int adminboard_id) throws SQLException {
		return (int) smc.update("board.countView", adminboard_id);
	}
}
