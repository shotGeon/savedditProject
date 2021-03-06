package kr.or.ddit.member.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemVO;

public class MemberDaoImpl implements IMemberDao{
	private static IMemberDao dao;
	
	private SqlMapClient smc;
	
	private MemberDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IMemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		
		return dao;
	}
	
	
	@Override
	public MemVO idCheck(MemVO mv) throws SQLException {
		return  (MemVO) smc.queryForObject("member.idCheck", mv);
	}

}
