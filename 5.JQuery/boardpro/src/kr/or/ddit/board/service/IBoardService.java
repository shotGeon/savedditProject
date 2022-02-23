package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	
	//전체리스트
	public List<BoardVO> selectAll();
	
	//페이지별 리스트
	public List<BoardVO> selectByPage(Map<String, Integer> map);
	
	//글쓰기
	public int insertBoard(BoardVO bv);
	
	//글수정
	public int updateBoard(BoardVO bv);
	
	//글삭제
	public int deleteBoard(int num);
	//댓글 쓰기
	public int insertReply(ReplyVO rv);
	
	//댓글 리스트
	public List<ReplyVO> selectReply(int bonum);
	
	//댓글 수정
	public int updateReply(ReplyVO rv);
	
	
	//댓글 삭제
	public int deleteReply(int renum);
	
	//조회수 증가
	public int replyHit(BoardVO bv);
	
	//전체 글 갯수
	public int getListCount();
}
