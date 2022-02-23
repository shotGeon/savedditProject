package dao;

import java.util.List;

import dto.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectMemberList() throws Exception;
}
