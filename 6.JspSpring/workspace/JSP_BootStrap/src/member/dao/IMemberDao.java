package member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Paging.PagingVO;
import memberVO.MemVO;

public interface IMemberDao {
	
	public List<MemVO> memberList(SqlSession session) throws Exception;
	



}
