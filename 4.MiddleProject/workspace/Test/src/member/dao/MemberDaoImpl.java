package member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import Paging.PagingVO;
import member.vo.MemVO;
import util.SqlMapClientFactory;

public class MemberDaoImpl implements IMemberDao{
	private static IMemberDao dao;
	
	private SqlMapClient smc;
	
	private MemberDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IMemberDao getInstance() {
		if(dao==null) {
			dao = new MemberDaoImpl();
		}
		
		return dao;
	}
	
	
	@Override
	public List<MemVO> memList() throws SQLException {
	
		return smc.queryForList("member.memList");
	}
	
	

	@Override
	public int memInsert(MemVO mv) throws SQLException {
		Object obj = smc.insert("member.memInsert", mv);
		int cnt =0;
		if(obj == null) {
			cnt++;
			return cnt; 
		}
		
		return  cnt;
	}

	@Override
	public MemVO memSelect(String ID) throws SQLException {
		return (MemVO) smc.queryForObject("member.memSelect", ID);
	}

	@Override
	public int memDelete(String ID) throws SQLException {
		return smc.delete("member.memDelete", ID);
	}

	@Override
	public int memUpdate(MemVO mv) throws SQLException {
		return smc.update("member.memUpdate", mv);
	}

	@Override
	public List<MemVO> findMem(PagingVO pv) throws SQLException {
		return smc.queryForList("member.findMem", pv);
	}

	@Override
	public int memTotalCount() throws SQLException {
		return (int) smc.queryForObject("member.memTotalCount");
	}

	@Override
	public List<MemVO> memPagingList(PagingVO pv) throws SQLException {
		return smc.queryForList("member.memPagingList", pv);
	}

	@Override
	public int memCheck(String id) throws SQLException {
		return (int) smc.queryForObject("member.memCheck", id);
	}

	@Override
	public int findSize(PagingVO pv) throws SQLException {
		return (int) smc.queryForObject("member.findSize", pv);
	}

	@Override
	public int memFindTotalCount(PagingVO pv) throws SQLException {
		return (int) smc.queryForObject("member.memFindTotalCount", pv);
	}
	

}
