package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao{
	
	private static IProdDao dao;
	
	private SqlMapClient smc;
	
	public ProdDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IProdDao getInstance() {
		if(dao==null) {
			dao = new ProdDaoImpl();
		}
		
		return dao;
	}
	
	
	@Override
	public List<ProdVO> selectProdByLgu(String prod_lgu) {
		
		List<ProdVO> list =null;
		
		try {
			list = smc.queryForList("prod.selectProdByLgu", prod_lgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ProdVO selectByIddetail(String prod_id) {
		
		ProdVO pv = null;
		
		try {
			pv= (ProdVO) smc.queryForObject("prod.selectByIddetail", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pv;
	}

}
