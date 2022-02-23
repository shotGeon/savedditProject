package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.prod.vo.ProdVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class ProdDaoImpl implements IProdDao{
	private static IProdDao dao;
	
	private SqlMapClient smc;
	
	private ProdDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IProdDao getInstance() {
		if(dao==null) {
			dao = new ProdDaoImpl();
		}
		
		return dao;
	}
	
	
	@Override
	public List<ProdVO> prodSelect() throws SQLException {
		return smc.queryForList("prod.prodSelect");
	}

	@Override
	public int prodInsert(ProdVO pv) throws SQLException {
		return (int) smc.insert("prod.prodInsert");
	}
	
}
