package kr.or.ddit.buyer.dao;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IBuyerDao {
	
	public int insertBuyer(BuyerVO bv);
	
	public List<BuyerVO> ListBuyer();
	
	public BuyerVO selectBuyer(String buyer_id);
	
	public int deleteBuyer(String buyer_id);
	
	public int updateBuyer(BuyerVO bv);
	
}
