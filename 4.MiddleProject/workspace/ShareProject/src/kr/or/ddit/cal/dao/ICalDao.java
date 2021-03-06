package kr.or.ddit.cal.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.cal.vo.CalVO;
import kr.or.ddit.cal.vo.TtVO;

public interface ICalDao {
	// 일정 조회
		public List<CalVO> calenList() throws SQLException;
		
		// 일정 리스트 조회
		public List<CalVO> calenListDetail(String day) throws SQLException;
		
		// 시간표 리스트 조회
		public List<TtVO> selectTt() throws SQLException;
		
		// 일정등록
		public int calInsert(CalVO vo) throws SQLException;
		
		// 시간표 등록
		public int ttInsert(TtVO vo) throws SQLException;
		
		// 일정 삭제
		public int calDelete(int id) throws SQLException;
		
		// 시간표 삭제
		public int ttDelete(int id) throws SQLException;
		
		// 일정 수정
		public int calUpdate(CalVO vo) throws SQLException;
		
		// 시간표 수정
		public int ttUpdate(TtVO vo) throws SQLException;
		
		// tt_id 조회
		public int ttIdSelect(TtVO vo) throws SQLException;
		
		// 멤버 그룹 조회
		public String mem_group(String mem_id) throws SQLException;
}
