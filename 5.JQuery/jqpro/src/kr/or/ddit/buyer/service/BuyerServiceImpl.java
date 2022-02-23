package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;

public class BuyerServiceImpl implements IBuyerService{
	
	private static IBuyerService service;

	private IBuyerDao dao;
	
	private BuyerServiceImpl() {
		dao = BuyerDaoImpl.getInstance();
	}
	
	public static IBuyerService getInstance() {
		if(service==null) {
			service = new BuyerServiceImpl();
		}
		
		return service;
	}
	

	
	
	@Override
	public List<BuyerVO> selectByName() {
		List<BuyerVO> list = null;
		
		list = dao.selectByName();
		
		return list;
		
		//return dao.selectByName();
	}

	@Override
	public BuyerVO selectDetail(String buyer_id) {
		
		return  dao.selectDetail(buyer_id);
	}
	
	
}
