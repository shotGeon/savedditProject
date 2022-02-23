package member.service;

import java.util.List;

import Paging.PagingVO;
import member.vo.MemVO;

public interface IMemberService {
	
	public List<MemVO> memList();
	
	public int memInsert(MemVO mv);
	
	public MemVO memSelect(String ID);
	
	public int memDelete(String ID);
	
	public int memUpdate(MemVO mv);
	
	public List<MemVO> findMem(PagingVO pv);
	
	public int memTotalCount();
	
	public List<MemVO> memPagingList(PagingVO pv);
	
	public int memCheck(String id);
	
	public int findSize(PagingVO pv);
	
	public int memFindTotalCount(PagingVO pv);

}
