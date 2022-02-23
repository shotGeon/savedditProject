package member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import command.Criteria;
import command.SearchCriteria;
import member.vo.MemberVO;


public interface IMemberDao {
	
	public List<MemberVO> memberList(SqlSession session) throws Exception;
	
	public List<MemberVO> memberList(SqlSession session, Criteria cri) throws Exception;
	
	public int memberListCount(SqlSession session) throws Exception;
	
	public int memberInsert(SqlSession session,MemberVO memberVO) throws Exception;
	
	public List<MemberVO> searchMemberList(SqlSession session, SearchCriteria searchCri) throws Exception;
	
	public int searchMemberListCount(SqlSession session, SearchCriteria searchCri) throws Exception;
	
	public MemberVO selectMemberByID(SqlSession session, String id) throws Exception;
	
	
	


}
