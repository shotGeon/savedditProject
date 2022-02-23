package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService{
	private static IProdService service;
	
	private IProdDao dao;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	public static IProdService getInstance() {
		if(service == null) {
			service = new ProdServiceImpl();
		}
		
		return service;
	}
	
	
	
	@Override
	public List<ProdVO> prodSelect() {
		List<ProdVO> list = null;
		
		try {
			list = dao.prodSelect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int prodInsert(ProdVO pv) {
		int cnt =0;
		try {
			cnt = dao.prodInsert(pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
