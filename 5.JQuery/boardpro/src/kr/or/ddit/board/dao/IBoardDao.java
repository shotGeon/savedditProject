package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {
	
		//전체리스트
		public List<BoardVO> selectAll() throws SQLException;
		
		//페이지별 리스트
		public List<BoardVO> selectByPage(Map<String, Integer> map) throws SQLException;
		
		//글쓰기
		public int insertBoard(BoardVO bv) throws SQLException;
		
		//글수정
		public int updateBoard(BoardVO bv) throws SQLException;
		
		//글삭제
		public int deleteBoard(int num) throws SQLException;
		//댓글 쓰기
		public int insertReply(ReplyVO rv) throws SQLException;
		
		//댓글 리스트
		public List<ReplyVO> selectReply(int bonum) throws SQLException;
		
		//댓글 수정
		public int updateReply(ReplyVO rv) throws SQLException;
		
		//댓글 삭제
		public int deleteReply(int renum) throws SQLException;
		
		//조회수 증가
		public int replyHit(BoardVO bv) throws SQLException;
		//전체 글 갯수 
		public int getListCount() throws SQLException;
}
