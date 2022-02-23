package member.service;

import java.sql.SQLException;
import java.util.List;

import Paging.PagingVO;
import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import member.vo.MemVO;

public class MemberServiceImpl implements IMemberService{
	private static IMemberService service;
	
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service==null) {
			service = new MemberServiceImpl();
		}
		
		return service;
	}
	
	
	
	@Override
	public List<MemVO> memList() {
		List<MemVO> list = null;
		
		try {
			list = dao.memList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int memInsert(MemVO mv) {
		int cnt =0;
		
		try {
			cnt = dao.memInsert(mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public MemVO memSelect(String ID) {
		MemVO mv = null;
		
		try {
			mv =dao.memSelect(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@Override
	public int memDelete(String ID) {
		int cnt =0;
		
		try {
			cnt = dao.memDelete(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int memUpdate(MemVO mv) {
		int cnt= 0;
		
		try {
			cnt = dao.memUpdate(mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemVO> findMem(PagingVO pv) {
		List<MemVO> list = null;
		
		try {
			list = dao.findMem(pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int memTotalCount() {
		int cnt =0;
		
		try {
			cnt = dao.memTotalCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemVO> memPagingList(PagingVO pv) {
		List<MemVO> list = null;
		
		try {
			list = dao.memPagingList(pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int memCheck(String id) {
		int cnt =0;
		
		try {
			cnt = dao.memCheck(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int findSize(PagingVO pv) {
		int cnt = 0;
		
		try {
			cnt = dao.findSize(pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int memFindTotalCount(PagingVO pv) {
		int cnt=0;
		
		try {
			cnt = dao.memFindTotalCount(pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
