package member.service;

import java.util.List;

import Paging.PagingVO;
import memberVO.MemVO;

public interface IMemberService {
	
	public List<MemVO> memberList() throws Exception;

}
