package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;

public class BuyerServiceImpl implements IBuyerService{
	private static IBuyerService service;
	private IBuyerDao dao;
	
	public BuyerServiceImpl() {
		dao = BuyerDaoImpl.getInstance();
	}
	
	public static IBuyerService getInstance() {
		if(service==null) {
			service = new BuyerServiceImpl();
		}
		
		return service;
	}
	
	@Override
	public int insertBuyer(BuyerVO bv) {
		
		return dao.insertBuyer(bv);
	}

	@Override
	public List<BuyerVO> ListBuyer() {
		System.out.println("BuyerServiceImpl->ListBuyer()");
		return dao.ListBuyer();
	}

	@Override
	public BuyerVO selectBuyer(String buyer_id) {
		return dao.selectBuyer(buyer_id);
	}

	@Override
	public int deleteBuyer(String buyer_id) {
		return dao.deleteBuyer(buyer_id);	}

	@Override
	public int updateBuyer(BuyerVO bv) {
		return dao.updateBuyer(bv);
	}

}
