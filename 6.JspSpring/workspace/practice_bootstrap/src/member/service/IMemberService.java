package member.service;

import java.util.List;
import java.util.Map;

import command.Criteria;
import member.vo.MemberVO;


public interface IMemberService {
	
	public List<MemberVO> memberList() throws Exception;
	
	public Map<String, Object> memberListPage(Criteria cri) throws Exception;
	
	public int memberInsert(MemberVO memberVO) throws Exception;
	
	public MemberVO getMember(String id) throws Exception;
	

}
