package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.GaesiDaoimpl;
import kr.or.ddit.member.dao.IGaesiDao;
import kr.or.ddit.member.vo.GaesiVO;

public class GaesiServiceimpl implements IGaesiService{
	
	private static IGaesiService gsv;
	
	private GaesiServiceimpl() {
	}
	
	public static IGaesiService getInstance() {
		
		if(gsv==null) {
			gsv= new GaesiServiceimpl();
		}
		
		return gsv;
	}
	
	
	
	IGaesiDao gdi = GaesiDaoimpl.getInstance();
	@Override
	public int insertBoard(GaesiVO gv) {
		return gdi.insertBoard(gv);
	}

	@Override
	public int updateBoard(int num, GaesiVO gv) {
		return gdi.updateBoard(num, gv);
	}

	@Override
	public int deleteBoard(int num) {
		return gdi.deleteBoard(num);
	}

	@Override
	public List<GaesiVO> displayAllBoard() {
		return gdi.displayAllBoard();
	}



	@Override
	public GaesiVO checkBoard(GaesiVO gv) {
		return gdi.checkBoard(gv);
	}

}
