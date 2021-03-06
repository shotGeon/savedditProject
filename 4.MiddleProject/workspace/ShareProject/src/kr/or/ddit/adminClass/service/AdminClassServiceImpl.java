package kr.or.ddit.adminClass.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.adminClass.dao.AdminClassDaoImpl;
import kr.or.ddit.adminClass.dao.IAdminClassDao;
import kr.or.ddit.adminClass.vo.AdminClassVO;
import kr.or.ddit.board.vo.PagingVO;

public class AdminClassServiceImpl implements IAdminClassService {
	private static IAdminClassService service;
	private IAdminClassDao dao;
	
	private AdminClassServiceImpl() {
		dao = AdminClassDaoImpl.getDao();
	}
	
	public static IAdminClassService GetService() {
		if(service == null) service = new AdminClassServiceImpl();
		return service;
	}

	@Override
	public List<AdminClassVO> groupByAllClass(PagingVO pv) {
		List<AdminClassVO> list = null;
		try {
			list = dao.groupByAllClass(pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int classSize() {
		int cnt = 0;
		try {
			cnt = dao.classSize();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteClass(String class_id) {
		int cnt = 0;
		try {
			cnt = dao.deleteClass(class_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int classUpdateMember(String class_id) {
		int cnt = 0;
		try {
			cnt = dao.classUpdateMember(class_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertClass(AdminClassVO vo) {
		int cnt = 0;
		try {
			cnt = dao.insertClass(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateClass(AdminClassVO vo) {
		int cnt = 0;
		try {
			cnt = dao.updateClass(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = dao.deleteMember(memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<AdminClassVO> groupByClassMember(PagingVO pv) {
		List<AdminClassVO> list = null;
		try {
			list = dao.groupByClassMember(pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int ClassMemberSize(String class_id) {
		int cnt = 0;
		try {
			cnt = dao.ClassMemberSize(class_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
