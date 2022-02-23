package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodDaoImpl implements ILprodDao{
	private static ILprodDao dao ;
	
	private SqlMapClient smc;
	
	public LprodDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ILprodDao getInstance() {
		if(dao ==null) {
			dao = new LprodDaoImpl();
		}
		
		return dao;
	}
	
	@Override
	public List<LprodVO> selectAllItem() {
			List<LprodVO> list = null;
			
			try {
				list = smc.queryForList("lprod.selectAllItem");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	
}
