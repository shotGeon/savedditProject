package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService{
	private static IMemberService service;
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao= MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service==null) {
			service = new MemberServiceImpl();
		}
		
		return service;
	}
	
	@Override
	public String selectById(String mem_id) {
		String id = null;
		
		try {
			id = dao.selectById(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<ZipVO> selectZipCode(String dong) {
		List<ZipVO> list = null;
		
		try {
			list = dao.selectZipCode(dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public String insertMember(MemberVO mv) {
		String mem_id = null;
		try {
			mem_id = dao.insertMember(mv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mem_id;
	}

}
