package member.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import member.dao.IMemberDao;
import memberVO.MemVO;

public class MemberServiceImpl implements IMemberService{
	private SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}
	
	private IMemberDao memberDAO;
	
	public void setMemberDao(IMemberDao memberDAO) {
		this.memberDAO=memberDAO;
	}
	
	public List<MemVO> memberList() throws Exception{
		SqlSession session = sqlSessionFactory.openSession(true);
		List<MemVO> memberList = new ArrayList<>();
		
		try {
			memberList = memberDAO.memberList(session);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		
		return memberList;
	}


}
