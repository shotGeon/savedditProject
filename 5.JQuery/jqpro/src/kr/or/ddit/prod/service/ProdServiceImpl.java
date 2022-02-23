package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService{
	
	private static IProdService service;
	
	private IProdDao dao;
	
	public ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	public static IProdService getInstance() {
		if(service==null) {
			service = new ProdServiceImpl();
		}
		
		return service;
	}
	
	
	
	
	@Override
	public List<ProdVO> selectProdByLgu(String prod_lgu) {
		return dao.selectProdByLgu(prod_lgu);
	}

	@Override
	public ProdVO selectByIddetail(String prod_id) {
		return dao.selectByIddetail(prod_id);
	}

}
