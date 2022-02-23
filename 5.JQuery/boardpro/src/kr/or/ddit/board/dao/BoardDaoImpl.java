package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao{
	private static IBoardDao dao;
	
	private SqlMapClient smc;
	
	private BoardDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IBoardDao getInstance() {
		if(dao==null) {
			dao = new BoardDaoImpl();
		}
		
		return dao;
	}
	
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		List<BoardVO> list = null;
		
		list = smc.queryForList("board.selectAll");
		return list;
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Integer> map) throws SQLException {
		List<BoardVO> list = smc.queryForList("board.selectByPage", map);
		return list;
	}

	@Override
	public int getListCount() throws SQLException {
		
		return (Integer) smc.queryForObject("board.getListCount");
	}

	@Override
	public int insertBoard(BoardVO bv) throws SQLException {
		
		
		return (Integer) smc.insert("board.insertBoard", bv);
	}

	@Override
	public int insertReply(ReplyVO rv) throws SQLException {
		return (Integer) smc.insert("reply.insertReply", rv);
	}

	@Override
	public List<ReplyVO> selectReply(int bonum) throws SQLException {
		return smc.queryForList("reply.selectReply", bonum);
	}

	@Override
	public int deleteReply(int renum) throws SQLException {
		return smc.delete("reply.deleteReply", renum);
	}

	@Override
	public int updateReply(ReplyVO rv) throws SQLException {
		return smc.update("reply.updateReply", rv);
	}

	@Override
	public int replyHit(BoardVO bv) throws SQLException {
		
		return smc.update("board.replyHit", bv);
	}

	@Override
	public int deleteBoard(int num) throws SQLException {
		
		return smc.delete("board.deleteBoard", num);
	}

	@Override
	public int updateBoard(BoardVO bv) throws SQLException {
		return smc.update("board.updateBoard", bv);
	}

}
