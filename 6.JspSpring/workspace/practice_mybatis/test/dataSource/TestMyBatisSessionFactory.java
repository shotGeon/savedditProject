package dataSource;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dto.MemberVO;

public class TestMyBatisSessionFactory {

	private SqlSessionFactory sqlSessionFactory = 
							new MyBatisSqlSessionFactory();
	
	private SqlSession session;
	
	@Before
	public void init() {
		session = sqlSessionFactory.openSession();
	}
	
	@Test
	public void testNotNullSession() {
		Assert.assertNotNull(session);
	}
	
	@Test
	public void testNotNullConnection() {
		Assert.assertNotNull(session.getConnection());
	}
	
	@Test
	public void testSql() throws SQLException {
		List<MemberVO> memberList = session.selectList("member-mapper.selectMemberList");
		
		
		Assert.assertEquals(5, memberList.size());
	}
	
	@After
	public void complete() {
		session.close();
	}

}
