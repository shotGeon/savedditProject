package service;

import java.util.List;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	
	@Override
	public List<MemberVO> getMemberList() throws Exception {
		
		return memberDAO.selectMemberList();
	}

}
