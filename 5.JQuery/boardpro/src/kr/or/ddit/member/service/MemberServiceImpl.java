package kr.or.ddit.member.service;

import java.sql.SQLException;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemVO;

public class MemberServiceImpl implements IMemberService{
	private static IMemberService service;
	
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	
	@Override
	public MemVO idCheck(MemVO mv) {
		MemVO mv2 = null;
		
		try {
			mv2 = dao.idCheck(mv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv2;
	}

}
