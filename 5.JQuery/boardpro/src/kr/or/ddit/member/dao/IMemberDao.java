package kr.or.ddit.member.dao;

import java.sql.SQLException;

import kr.or.ddit.member.vo.MemVO;

public interface IMemberDao {
	
	public MemVO idCheck(MemVO mv) throws SQLException;
}
