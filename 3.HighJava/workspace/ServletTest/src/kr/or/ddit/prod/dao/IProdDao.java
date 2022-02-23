package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdDao {
	
	public List<ProdVO> prodSelect() throws SQLException;
	
	public int prodInsert(ProdVO pv) throws SQLException;
	
}
