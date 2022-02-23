package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {
	
	public String selectById(String mem_id) 
			                  throws SQLException;
	//우편번호찾기
	public List<ZipVO> selectZipCode(String dong)
	                          throws SQLException;
	
	public String insertMember(MemberVO mv) throws SQLException;
	
}
