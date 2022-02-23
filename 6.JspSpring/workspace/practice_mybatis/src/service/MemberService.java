package service;

import java.util.List;

import dto.MemberVO;

public interface MemberService {
	
	public List<MemberVO> getMemberList() throws Exception;
}
