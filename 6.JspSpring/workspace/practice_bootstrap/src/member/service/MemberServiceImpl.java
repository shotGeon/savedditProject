package member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import command.Criteria;
import command.PageMaker;
import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import member.vo.MemberVO;
import util.MyBatisSqlSessionFactory;

public abstract class MemberServiceImpl implements IMemberService{
	protected SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory();
	private SqlSession session;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}
	
	protected IMemberDao memberDAO = new MemberDaoImpl();
	
	public void setMemberDAO(IMemberDao memberDAO) {
		this.memberDAO=memberDAO;
	}
	
	public List<MemberVO> memberList() throws Exception{
		SqlSession session = sqlSessionFactory.openSession(false);
		List<MemberVO> memberList = new ArrayList<>();
		
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

	@Override
	public int memberInsert(MemberVO memberVO) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		int count =0;
		try {			
			count = memberDAO.memberInsert(session, memberVO);
			System.out.println("count"+count);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		return count;
	}

	@Override
	public Map<String, Object> memberListPage(Criteria cri) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		Map<String, Object> dataMap = null;
		List<MemberVO> memberList=null;
		PageMaker pageMaker = null;
		
		try {
			memberList = memberDAO.memberList(session, cri);
			pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberDAO.memberListCount(session));
			
			dataMap = new HashMap<String, Object>();
			
			dataMap.put("memberList", memberList);
			dataMap.put("pageMaker", pageMaker);
			
			
			session.commit();
			
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return dataMap;
	}

	@Override
	public abstract MemberVO getMember(String id) throws Exception; 
	


}
