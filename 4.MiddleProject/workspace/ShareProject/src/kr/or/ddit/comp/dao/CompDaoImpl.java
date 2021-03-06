package kr.or.ddit.comp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.comp.vo.CompPagingVO;
import kr.or.ddit.comp.vo.CompVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class CompDaoImpl implements ICompDao{

	private SqlMapClient smc;
	private static ICompDao dao;
	
	private CompDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ICompDao getInstance() {
		if(dao == null) {
			dao = new CompDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<CompVO> selectAll() throws SQLException {
		
		return smc.queryForList("com.selectAll");
	}

	@Override
	public CompVO selectOne(int adminboard_id) throws SQLException {
		
		return (CompVO) smc.queryForObject("com.selectOne" , adminboard_id);
	}

	@Override
	public int countComp() throws SQLException {
		
		return (int) smc.queryForObject("com.selectTotalCnt");
	}

	@Override
	public int insertComp(CompVO vo) throws SQLException {
		
		return (int) smc.insert("com.insertComp", vo);
	}

	@Override
	public int updateComp(CompVO vo) throws SQLException {
		
		return smc.update("com.updateComp", vo);
	}

	@Override
	public int delteComp(int adminboard_id) throws SQLException {
		
		return smc.delete("com.deleteComp", adminboard_id);
	}

	@Override
	public List<CompVO> selectPage(CompPagingVO vo) throws SQLException {
		
		return smc.queryForList("com.pagingComp", vo);
	}

	@Override
	public List<CompVO> findCmTitle(CompPagingVO cv) throws SQLException {
		return smc.queryForList("com.findCmTitle", cv);
	}

	@Override
	public int findCmtitleCount(String comp_name) throws SQLException {
		return (int) smc.queryForObject("com.findCmtitleCount", comp_name);
	}

	@Override
	public int countView(int adminboard_id) throws SQLException {
		return (int) smc.update("com.countView", adminboard_id);
	}

}
