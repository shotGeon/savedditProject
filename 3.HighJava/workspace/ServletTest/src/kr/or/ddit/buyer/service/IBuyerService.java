package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IBuyerService {
	
	public int insertBuyer(BuyerVO bv);
	
	public List<BuyerVO> ListBuyer();
	
	public BuyerVO selectBuyer(String buyer_id);
	
	public int deleteBuyer(String buyer_id);
	
	public int updateBuyer(BuyerVO bv);
}
