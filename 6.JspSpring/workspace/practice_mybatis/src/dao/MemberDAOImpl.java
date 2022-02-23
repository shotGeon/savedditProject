package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dataSource.MyBatisSqlSessionFactory;
import dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	
	@Override
	public List<MemberVO> selectMemberList() throws Exception {
		sqlSessionFactory = new MyBatisSqlSessionFactory();
		session = sqlSessionFactory.openSession();
		List<MemberVO> memberList = session.selectList("member-mapper.selectMemberList");
//		System.out.println(1/0);
		return memberList;
	}

}
