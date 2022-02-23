package member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import command.Criteria;
import command.PageMaker;
import command.SearchCriteria;
import member.vo.MemberVO;

public class SearchMemberServiceImpl extends MemberServiceImpl{

	@Override
	public Map<String, Object> memberListPage(Criteria cri) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		SearchCriteria searchCri = (SearchCriteria)cri;
		Map<String, Object> dataMap=null;
		List<MemberVO> memberList = null;
		PageMaker pageMaker = null;
		
		try {
			memberList = memberDAO.searchMemberList(session, searchCri);
			pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberDAO.searchMemberListCount(session, searchCri));
			
			dataMap = new HashMap<String, Object>();
			
			dataMap.put("memberList", memberList);
			dataMap.put("pageMaker", pageMaker);
			
			session.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
			throw e;
		}finally {
			session.close();
		}
		
		return dataMap;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		MemberVO member = null;
		
		try {
			member = memberDAO.selectMemberByID(session, id);
			session.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
			throw e;
		}finally {
			session.close();
		}
		
		return member;
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
	
	

}
