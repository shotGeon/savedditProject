package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class BuyerDaoImpl implements IBuyerDao{
	private static IBuyerDao dao;
	private static SqlMapClient smc;
	
	private BuyerDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IBuyerDao getInstance() {
		if(dao==null) {
			dao = new BuyerDaoImpl();
		}
		
		return dao;
	}
	
	
	@Override
	public int insertBuyer(BuyerVO bv) {
		int cnt=0;
		
		try {
			cnt = smc.update("buyer.insertBuyer", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<BuyerVO> ListBuyer() {
		
		List<BuyerVO> list= new ArrayList<BuyerVO>();
		System.out.println("BuyerDaoImpl->ListBuyer()");
		try {
			if(smc==null) {
				smc = SqlMapClientFactory.getInstance();
			}
			System.out.println("smc : " + smc);
			list = smc.queryForList("buyer.ListBuyer");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BuyerVO selectBuyer(String buyer_id) {
		BuyerVO bv = new BuyerVO();
		
		try {
			bv = (BuyerVO) smc.queryForObject("buyer.selectBuyer",buyer_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bv;
	}

	@Override
	public int deleteBuyer(String buyer_id) {
		int cnt=0;
			try {
				cnt=smc.delete("buyer.deleteBuyer",buyer_id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return cnt;
	}

	@Override
	public int updateBuyer(BuyerVO bv) {
		int cnt= 0;
		
		try {
			cnt=smc.update("buyer.updateBuyer", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}
