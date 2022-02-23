package member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import Paging.PagingVO;
import memberVO.MemVO;
import util.MyBatisSqlSessionFactory;

public class MemberDaoImpl implements IMemberDao{
	
	
	public List<MemVO> memberList(SqlSession session) throws Exception{
		return session.selectList("member.memberList");
	}
	


}
