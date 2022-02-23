package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberDaoImpl implements IMemberDao{
	
	private static IMemberDao dao;
	private SqlMapClient smc;
	
	private MemberDaoImpl() {
		smc= SqlMapClientFactory.getInstance();
	}
	
	public static IMemberDao getInstance() {
		if(dao==null) {
			dao = new MemberDaoImpl();
		}
		
		return dao;
	}
	
	
	
	@Override
	public String selectById(String mem_id) throws SQLException {
			String id = null;
			
			id= (String) smc.queryForObject
					    ("member.selectById", mem_id);
		return id;
	}

	@Override
	public List<ZipVO> selectZipCode(String dong) throws SQLException {
			List<ZipVO> list = null;
			
			list=smc.queryForList("member.selectZipCode", dong);
			
			
		return list;
	}

	@Override
	public String insertMember(MemberVO mv) throws SQLException {
		String mem_id = null;
		
		mem_id = (String) smc.insert("member.insertMember", mv);
		
		return mem_id;
	}

}
