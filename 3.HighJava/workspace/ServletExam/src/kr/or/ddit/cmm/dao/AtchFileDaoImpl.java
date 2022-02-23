package kr.or.ddit.cmm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.cmm.vo.AtchFileVO;
import kr.or.ddit.util.SqlMapClientPactory;

public class AtchFileDaoImpl implements IAtchFileDao{
	private static IAtchFileDao dao;
	private SqlMapClient smc;
	
	private AtchFileDaoImpl() {
		smc = SqlMapClientPactory.getInstance();
	}
	
	public static IAtchFileDao getInstance() {
		if(dao==null) {
			dao = new AtchFileDaoImpl();
		}
		
		return dao;
	}
	
	
	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) {
		int cnt =0;
		
		try {
			Object obj=smc.insert("atch_file.insertAtchFile", atchFileVO);
			if(obj==null) {
				cnt=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertAtchFileDetail(AtchFileVO atchFileVO) {
		int cnt=0;
		
		try {
			Object obj = smc.insert("atch_file.insertAtchFileDetail", atchFileVO);
			
			if(obj==null) {
				cnt=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) {
		List<AtchFileVO> list = new ArrayList<AtchFileVO>();
		
		try {
			list= smc.queryForList("atch_file.getAtchFileList", atchFileVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		AtchFileVO vo = null;
		
		try {
			vo=(AtchFileVO) smc.queryForObject
					      ("atch_file.getAtchFileDetail", atchFileVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

}
