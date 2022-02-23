package member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import command.Criteria;
import command.SearchCriteria;
import member.vo.MemberVO;
import util.MyBatisSqlSessionFactory;

public class MemberDaoImpl implements IMemberDao{
	
	
	public List<MemberVO> memberList(SqlSession session) throws Exception{
		return session.selectList("member.memberList");
	}

	@Override
	public int memberInsert(SqlSession session, MemberVO memberVO) throws Exception {
		return session.insert("member.memberInsert", memberVO);
	}

	@Override
	public List<MemberVO> memberList(SqlSession session, Criteria cri) throws Exception {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return session.selectList("member.memberList", null, rowBounds);
	}

	@Override
	public int memberListCount(SqlSession session) throws Exception {
		return session.selectOne("member.memberListCount");
	}

	@Override
	public List<MemberVO> searchMemberList(SqlSession session, SearchCriteria searchCri) throws Exception {
		int offset = searchCri.getStartRowNum();
		int limit = searchCri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MemberVO> memberList = session.selectList("member.searchMemberList", searchCri, rowBounds);
		
		return memberList;
	}

	@Override
	public int searchMemberListCount(SqlSession session, SearchCriteria searchCri) throws Exception {
		int count =0;
		
		count = session.selectOne("member.searchMemberListCount", searchCri);
		
		return count;
	}

	@Override
	public MemberVO selectMemberByID(SqlSession session, String id) throws Exception {
		MemberVO member = null;
		member = session.selectOne("member.selectMemberByID", id);
		return member;
	}

	
	


}
