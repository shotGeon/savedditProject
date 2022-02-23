package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

//mapper에 접근해서 sql문을 실행 -SqlMapClient객체가 필요
//싱글톤 처리 - service클래스에서 사용하기 위한 dao객체를 생성하여 리턴한다.
public class BuyerDaoImpl implements IBuyerDao{
	
	private SqlMapClient client;
	private static IBuyerDao dao;
	
	private BuyerDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IBuyerDao getInstance() {
		if(dao==null) {
			dao = new BuyerDaoImpl();
		}
		return dao;
	}
	
	
	
	@Override
	public List<BuyerVO> selectByName() {
		List<BuyerVO> list = null;
		
		try {
			list=client.queryForList("buyer.selectByName");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BuyerVO selectDetail(String buyer_id) {
		BuyerVO vo = null;
		
		try {
			vo = (BuyerVO) client.queryForObject("buyer.selectDetail", buyer_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return vo;
	}

}
