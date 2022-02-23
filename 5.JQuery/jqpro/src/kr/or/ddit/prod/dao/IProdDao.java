package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdDao {
	
	public List<ProdVO> selectProdByLgu(String prod_lgu);  
	
	public ProdVO selectByIddetail(String prod_id);
}
