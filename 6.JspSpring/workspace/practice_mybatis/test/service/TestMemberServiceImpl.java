package service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.MockMemberDAOImpl;
import dto.MemberVO;

public class TestMemberServiceImpl {
	MemberService service = new MemberServiceImpl();
	
	
	{
		((MemberServiceImpl) service).setMemberDAO(new MockMemberDAOImpl());
	}
	
	@Test
	public void testGetMemberList() throws Exception {
		List<MemberVO> memberList = service.getMemberList();
		
		Assert.assertEquals(10, memberList.size());
		Assert.assertEquals("kk0", memberList.get(0).getId());
		
		
	}
	
	
	
}
