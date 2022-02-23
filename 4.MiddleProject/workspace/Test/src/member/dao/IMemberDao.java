package member.dao;

import java.sql.SQLException;
import java.util.List;

import Paging.PagingVO;
import member.vo.MemVO;

public interface IMemberDao {
	
	public List<MemVO> memList() throws SQLException;
	
	public int memInsert(MemVO mv) throws SQLException;
	
	public MemVO memSelect(String ID) throws SQLException;
	
	public int memDelete(String ID) throws SQLException;
	
	public int memUpdate(MemVO mv) throws SQLException;
	
	public List<MemVO> findMem(PagingVO pv) throws SQLException;
	
	public int memTotalCount() throws SQLException;
	
	public List<MemVO> memPagingList(PagingVO pv) throws SQLException;
	
	public int memCheck(String id) throws SQLException;
	
	public int findSize(PagingVO pv) throws SQLException;
	
	public int memFindTotalCount(PagingVO pv) throws SQLException;
}
