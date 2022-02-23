package dao;

import java.util.ArrayList;
import java.util.List;

import dto.MemberVO;

public class MockMemberDAOImpl implements MemberDAO{
	
	public List<MemberVO> selectMemberList() throws Exception{
		List<MemberVO> memberList = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			memberList.add(new MemberVO("kk"+i,"kk"+i));
		}
		
		return memberList;
	}

}
