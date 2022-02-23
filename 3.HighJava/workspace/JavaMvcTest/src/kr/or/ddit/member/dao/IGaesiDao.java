package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.GaesiVO;

public interface IGaesiDao {

	public int insertBoard(GaesiVO gv);
	
	public int updateBoard(int num, GaesiVO gv);
	
	public int deleteBoard(int num);
	
	public List<GaesiVO> displayAllBoard();
	
	
	public GaesiVO checkBoard(GaesiVO gv);
	
	
}
