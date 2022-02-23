package test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import util.MyBatisSqlSessionFactory;

public class TestMyBatisSessionFactory {
	SqlSessionFactory factory = new MyBatisSqlSessionFactory();
	
	SqlSession session;
	
	@Before
	public void init() {
		session = factory.openSession();
	}
	
	@Test
	public void testNotNullSession() {
		Assert.assertNotNull(session);
	}
	
	@After
	public void complete() {
		session.close();
	}
}
