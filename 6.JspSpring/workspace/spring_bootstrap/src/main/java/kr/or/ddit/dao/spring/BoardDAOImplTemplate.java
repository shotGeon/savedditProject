package kr.or.ddit.dao.spring;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.SearchCriteria;
import com.jsp.dao.BoardDAO;
import com.jsp.dto.BoardVO;

public class BoardDAOImplTemplate implements BoardDAOBean{

	private SqlSession session;
	
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public List<BoardVO> selectSearchBoardList(SearchCriteria cri) throws SQLException {
		return boardDAO.selectSearchBoardList(session, cri);
	}

	@Override
	public int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		return boardDAO.selectBoardCriteriaTotalCount(session, cri);
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		return boardDAO.selectBoardByBno(session, bno);
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		boardDAO.insertBoard(session, board);
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		boardDAO.updateBoard(session, board);
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		boardDAO.deleteBoard(session, bno);
	}

	@Override
	public void increaseViewCnt(int bno) throws SQLException {
		boardDAO.increaseViewCnt(session, bno);
	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		return boardDAO.selectBoardSeqNext(session);
	}

	@Override
	public BoardVO selectBoardByImage(String imageFile) throws SQLException {
		BoardVO board = session.selectOne("Board-Mapper.selectBoardByImage", imageFile);
		return board;
	}

}
