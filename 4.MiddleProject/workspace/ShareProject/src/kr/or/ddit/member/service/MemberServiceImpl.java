package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.PagingVO;
import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.ClassVO;
import kr.or.ddit.member.vo.MemVO;
import kr.or.ddit.member.vo.MsgVO;

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

	@Override
	public int memLock(MemVO mv) {
		int cnt =0;
		try {
			cnt = dao.memLock(mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int chkCheck(String mem_id) {
		int chk = 0;
		
		try {
			chk = dao.chkCheck(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public MemVO memAll(String mem_id) {
		MemVO mv = null;
		
		try {
			mv = dao.memAll(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@Override
	public ClassVO memClass(String class_id) {
		ClassVO cv =null;
		
		try {
			cv = dao.memClass(class_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cv;
	}

	@Override
	public int updateMem(MemVO mv) {
		int cnt =0;
		
		try {
			cnt = dao.updateMem(mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<MsgVO> msgList(String msg_from) {
		List<MsgVO> list = null;
		
		try {
			list = dao.msgList(msg_from);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int senMsg(MsgVO mv) {
		int cnt =0;
		
		try {
			cnt=dao.sendMsg(mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMsg(int msg_num) {
		int cnt = 0;
		
		try {
			cnt = dao.deleteMsg(msg_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	@Override
	public MsgVO selectMsg(int msg_num) {
		MsgVO mv = null;
		
		try {
			mv = dao.selectMsg(msg_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@Override
	public int memReset(MemVO mv) {
		int cnt = 0;
		
		try {
			cnt = dao.memReset(mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int msgSize(String msg_from) {
		int cnt =0;
		
		try {
			cnt = dao.msgSize(msg_from);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MsgVO> groupByAllMsg(PagingVO pv) {
		List<MsgVO> list = null;
		
		try {
			list = dao.groupByAllMsg(pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String memName(String mem_id) {
		String mem_name =null;
		
		try {
			mem_name = dao.memName(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem_name;
	}

	@Override
	public String memGroup(String mem_id) {
		String mem_group =null;
		try {
			mem_group = dao.memGroup(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem_group;
	}
	
}
