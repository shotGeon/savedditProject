package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	//id중복검사
	public String selectById(String mem_id);
	
	//우편번호찾기
	public List<ZipVO> selectZipCode(String dong);
	
	public String insertMember(MemberVO mv);
}
