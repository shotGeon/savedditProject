package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.AdminreVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class AdminreDaoImpl implements IAdminreDao{
	private static IAdminreDao dao ;
	private SqlMapClient smc ;
	
	private AdminreDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IAdminreDao getInstance() {
		if(dao==null) {
			dao = new AdminreDaoImpl();
		}
		
		return dao;
	}
	@Override
	public int insertAdminre(AdminreVO av) throws SQLException {
		return (int) smc.insert("adminre.insertAdminre", av);
	}

	@Override
	public List<AdminreVO> selectResponse(int adminboard_id) throws SQLException {
		return (List<AdminreVO>) smc.queryForList("adminre.selectResponse", adminboard_id);
	}

	@Override
	public String selectmemId(int adminboard_id) throws SQLException {
		return (String) smc.queryForObject("adminre.selectmemId", adminboard_id);
	}

	@Override
	public int updateResponse(AdminreVO arv) throws SQLException {
		return (int) smc.update("adminre.updateResponse", arv);
	}

	@Override
	public int deleteResponse(int adminre_num) throws SQLException {
		return smc.delete("adminre.deleteResponse", adminre_num);
	}

}


