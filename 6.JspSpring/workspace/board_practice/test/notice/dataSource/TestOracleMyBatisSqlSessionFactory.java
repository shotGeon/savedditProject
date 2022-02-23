package notice.dataSource;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestOracleMyBatisSqlSessionFactory {
	private SqlSessionFactory sqlSessionFactory = new OracleMyBatisSqlSessionFactory();
	
	private SqlSession session;
	
	@Before
	public void init() {
		session = sqlSessionFactory.openSession();
	}
	
	@Test
	public void test() {
		Assert.assertNotNull(session);
	}
	
	@After
	public void finish() {
		session.close();
	}

}
